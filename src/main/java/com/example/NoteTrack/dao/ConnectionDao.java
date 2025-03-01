package com.example.NoteTrack.dao;

import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IConnectionDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao implements IConnectionDao {
    private static ConnectionDao instance;
    private DatabaseConfig config;

    private ConnectionDao(DatabaseConfig config) {
        this.config = config;
    }

    public static ConnectionDao getInstance(DatabaseConfig config) {
        if (instance == null) {
            instance = new ConnectionDao(config);
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(config.getDbURL(), config.getUsername(), config.getPassword());
            if (conn != null) {
                System.out.println("✅ Connexion à la base de données établie avec succès !");
            } else {
                System.err.println("❌ Échec de la connexion à la base de données !");
            }

            return conn;
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found!", e);
        }
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
