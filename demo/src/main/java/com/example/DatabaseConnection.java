package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "1234";

        return DriverManager.getConnection(url, username, password);
    }
}
