package com.example.NoteTrack.dao;

import com.example.NoteTrack.entities.Signature;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.ISignatureDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SignatureDao implements ISignatureDao {

    private Connection connection;
    private String table;

    public SignatureDao(Connection connection) {
        this.connection = connection;
        this.table = "Signature"; // Nom de la table en base de données
    }

    public SignatureDao(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    @Override
    public boolean ajouterSignature(Signature signature) {
        String sql = "INSERT INTO " + table + " (professeurSignature  , dateSignatureProf, userId, idSeance) VALUES (?, ?, ? , ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, signature.isProfesseurSignature());
            stmt.setTimestamp(2, Timestamp.valueOf(signature.getDateSignatureProf()));
            stmt.setInt(3, signature.getUserId());
            stmt.setInt(4, signature.getSeanceId());
            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean modifierSignature(Signature signature) {
        String sql = "UPDATE " + table + " SET professeurSignature = ? ,  dateSignatureProf = ?, userId = ?, idSeance = ? WHERE idSignature = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, signature.isProfesseurSignature());
            stmt.setTimestamp(2, Timestamp.valueOf(signature.getDateSignatureProf()));
            stmt.setInt(3, signature.getUserId());
            stmt.setInt(4, signature.getSeanceId());
            stmt.setInt(4, signature.getId());

            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean supprimerSignature(int id) {
        String sql = "DELETE FROM " + table + " WHERE idSignature = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Signature getSignatureById(int id) {
        String sql = "SELECT * FROM " + table + " WHERE idSignature = ?";
        Signature signature = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                signature = mapSignature(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return signature;
    }

    @Override
    public List<Signature> getAllSignatures() {
        String sql = "SELECT * FROM " + table;
        List<Signature> signatures = new ArrayList<>();

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                signatures.add(mapSignature(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return signatures;
    }

    public Signature mapSignature(ResultSet rs) throws SQLException {
        return new Signature(
                rs.getInt("idSignature"),
                rs.getInt("userId"),
                rs.getInt("idSeance"),
                rs.getBoolean("professeurSignature"),
                rs.getTimestamp("dateSignatureProf").toLocalDateTime()
        );
    }
}
