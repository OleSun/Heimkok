package com.transport.connecton.actiontable;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class addButton extends JButton {
    private JTable table;
    private String dbUrl;
    private String username;
    private String password;
    private String tableName;

    public addButton(String text, JTable table, String tableName, String dbUrl, String username, String password) {
        super(text);
        this.table = table;
        this.tableName = tableName;
        this.dbUrl = dbUrl;
        this.username = username;
        this.password = password;
        addActionListener(new AddActionListener());
    }

    private class AddActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Map<String, Object> rowData = new HashMap<>();

            // Create text fields for adding data
            Map<String, JTextField> columnTextFields = new HashMap<>();
            JPanel panel = new JPanel(new GridLayout(0, 2)); // 2 columns

            for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
                String columnName = table.getColumnName(columnIndex); // Fixed the missing parenthesis here

                if (!columnName.equalsIgnoreCase("notes")) {
                    // Exclude the "notes" column
                    JLabel label = new JLabel(columnName);
                    JTextField textField = new JTextField();
                    columnTextFields.put(columnName, textField);
                    panel.add(label);
                    panel.add(textField);
                }
            }

            // Show the dialog to add data
            int result = JOptionPane.showConfirmDialog(null, panel, "Add",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                // Extract values from text fields
                for (Map.Entry<String, JTextField> entry : columnTextFields.entrySet()) {
                    String columnName = entry.getKey();
                    JTextField textField = entry.getValue();
                    String value = textField.getText();
                    rowData.put(columnName, value);
                }

                // Insert the new data into the table and the database
                insertData(tableName, rowData);
            }
        }
    }

    private void insertData(String tableName, Map<String, Object> columnData) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(dbUrl, username, password);

            StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
            queryBuilder.append(tableName);
            queryBuilder.append(" (");

            // Create a list to hold the column names for the INSERT INTO clause
            for (String columnName : columnData.keySet()) {
                queryBuilder.append(columnName).append(", ");
            }
            queryBuilder.setLength(queryBuilder.length() - 2); // Remove the trailing comma and space
            queryBuilder.append(") VALUES (");

            // Create placeholders for values in the SQL query
            for (String columnName : columnData.keySet()) {
                queryBuilder.append("?, ");
            }
            queryBuilder.setLength(queryBuilder.length() - 2); // Remove the trailing comma and space
            queryBuilder.append(")");

            preparedStatement = connection.prepareStatement(queryBuilder.toString());

            // Set values for the columns
            int parameterIndex = 1;
            for (Object columnValue : columnData.values()) {
                preparedStatement.setObject(parameterIndex++, columnValue);
            }

            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Data added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No data added. Please check your inputs.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding data: " + e.getMessage());
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
