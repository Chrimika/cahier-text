package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IConnectionDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IConnectionService;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionService implements IConnectionService {

    private static ConnectionService instance; // Singleton
    private final IConnectionDao connectionDao;
    private final Connection connection;

    private ConnectionService() throws SQLException {
        this.connectionDao = ConnectionDao.getInstance(new DatabaseConfig());
        this.connection = this.connectionDao.getConnection();
    }

    // Singleton : obtenir une seule instance réutilisable
    public static synchronized ConnectionService getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionService();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() {
        connectionDao.closeConnection(this.connection);
    }
}
