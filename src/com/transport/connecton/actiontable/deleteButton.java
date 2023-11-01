package com.transport.connecton.actiontable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteButton extends JButton {
    private JTable table;
    private String dbUrl;
    private String username;
    private String password;
    private String tableName;
    private String primaryKeyColumnName;

    public deleteButton(String text, JTable table, String primaryKeyColumnName, String tableName,
                        String dbUrl, String username, String password) {
        super(text);
        this.table = table;
        this.primaryKeyColumnName = primaryKeyColumnName;
        this.tableName = tableName;
        this.dbUrl = dbUrl;
        this.username = username;
        this.password = password;
        addActionListener(new DeleteActionListener());
    }

    private class DeleteActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int primaryKeyValue = (int) table.getValueAt(selectedRow, table.getColumnModel().getColumnIndex(primaryKeyColumnName));
                
                int result = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?", "Delete",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    // Delete the record from the table and the database
                    deleteData(tableName, primaryKeyColumnName, primaryKeyValue);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            }
        }
    }

    private void deleteData(String tableName, String primaryKeyColumnName, int primaryKeyValue) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(dbUrl, username, password);

            String deleteQuery = "DELETE FROM " + tableName + " WHERE " + primaryKeyColumnName + " = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, primaryKeyValue);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Record deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No record deleted. Please check your inputs.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting record: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

