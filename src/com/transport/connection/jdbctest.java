package com.transport.connection;
import java.sql.*;


public class jdbctest {

    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://127.0.0.1:3306/classicmodels";
        String user = "root";
        String code = "HAH020503Ah";

        try {
            // 1. Get a connection to the database
            myConn = DriverManager.getConnection(dbUrl, user, code);
            
            System.out.printf("Connection Successful");
            
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }

    }

}