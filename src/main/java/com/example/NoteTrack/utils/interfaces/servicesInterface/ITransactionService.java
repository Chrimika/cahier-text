package com.example.NoteTrack.utils.interfaces.servicesInterface;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface ITransactionService {
    @FunctionalInterface
    interface TransactionalOperation<T> {
        T execute(Connection connection) throws SQLException;
    }

    <T> T executeTransaction(TransactionalOperation<T> operation);
}
