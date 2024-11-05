package com.costomer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBase {

    public static final String url = "jdbc:mysql://localhost:3306/user";
    public static final String username = "root";
    public static final String password = "12345678abc#";


   public static Connection getConnection() {
        Connection conn = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error establishing connection to the database.");
            e.printStackTrace();
        }
        return conn;
    }
}