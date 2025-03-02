package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.dao.ConnectionDao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionDao {

    Connection getConnection() throws SQLException;
    void closeConnection(Connection connection);
}
