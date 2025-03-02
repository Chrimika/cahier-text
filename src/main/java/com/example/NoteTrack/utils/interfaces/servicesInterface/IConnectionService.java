package com.example.NoteTrack.utils.interfaces.servicesInterface;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionService {
    Connection getConnection() throws SQLException;
    void closeConnection();
}
