package com.example.NoteTrack.dao;

import com.example.NoteTrack.utils.interfaces.daoInterfaces.connectionDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDaoImpl implements connectionDao {

    private static connectionDaoImpl instance;
    private String dbURL;
    private String username;
    private String password;

    private connectionDaoImpl(String dbURL, String username, String password) {
        this.dbURL = dbURL;
        this.username = username;
        this.password = password;
    }

    public static connectionDaoImpl getInstance(String dbURL, String username, String password) {
        if (instance == null) {
            instance = new connectionDaoImpl(dbURL, username, password);
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver (if not already loaded)
            Class.forName("com.mysql.cj.jdbc.Driver"); // Replace with your driver class
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found!");
            e.printStackTrace();
            throw new SQLException("JDBC Driver not found!"); //Re-throw for handling higher up
        }

        return DriverManager.getConnection(dbURL, username, password);
    }


    @Override
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
