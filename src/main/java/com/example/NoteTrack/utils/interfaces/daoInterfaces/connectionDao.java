package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface connectionDao {

    Connection getConnection() throws SQLException;
    void closeConnection(Connection connection);
}
