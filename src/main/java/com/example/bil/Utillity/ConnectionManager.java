package com.example.bil.Utillity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private Connection connection;

    public ConnectionManager() throws SQLException {
        String url = System.getProperty("DB_URL", System.getenv("DB_URL"));
        String user = System.getProperty("DB_USER", System.getenv("DB_USER"));
        String password = System.getProperty("DB_PASSWORD", System.getenv("DB_PASSWORD"));

        this.connection = DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        return this.connection;
    }

    }