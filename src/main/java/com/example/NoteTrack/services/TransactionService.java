package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.servicesInterface.ITransactionService;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionService implements ITransactionService {
    private static TransactionService instance;
    private final Connection connection;

    private TransactionService() throws SQLException {
        this.connection = ConnectionService.getInstance().getConnection();
    }

    public static TransactionService getInstance() throws SQLException {
        if (instance == null) {
            instance = new TransactionService();
        }
        return instance;
    }

    @Override
    public <T> T executeTransaction(TransactionalOperation<T> operation) {
        try {
            connection.setAutoCommit(false); // Désactiver l'auto-commit

            T result = operation.execute(connection);

            connection.commit(); // Valider la transaction
            return result;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Annuler en cas d'erreur
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            throw new RuntimeException("Erreur lors de l'exécution de la transaction", e);
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close(); // Fermer la connexion
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }
}
