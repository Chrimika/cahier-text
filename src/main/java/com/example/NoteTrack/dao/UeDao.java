package com.example.NoteTrack.dao;

import com.example.NoteTrack.entities.UE;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IUeDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UeDao implements IUeDao {

    private Connection connection;
    private String table;

    public UeDao(Connection connection) {
        this.connection = connection;
        this.table = "UE";
    }

    public UeDao(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    @Override
    public boolean ajouterUE(UE ue) {
        String sql = "INSERT INTO " +table + " (codeUe, nom, nombreHeures , codeNiveau) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ue.getCode());
            stmt.setString(2, ue.getNom());
            stmt.setInt(3, ue.getNombreHeures());
            stmt.setString(3, ue.getCodeNiveau());
            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean modifierUE(UE ue) {
        String sql = "UPDATE " +table + " SET nom = ?, nombreHeures = ? , codeUe = ? , codeNiveau = ? WHERE codeUe = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ue.getNom());
            stmt.setInt(2, ue.getNombreHeures());
            stmt.setString(3, ue.getCode());
            stmt.setString(4, ue.getCodeNiveau());
            stmt.setString(5, ue.getCode());

            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean supprimerUE(String code) {
        String sql = "DELETE FROM " +table + " WHERE codeUe = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, code);
            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public UE getUEBycode(String code) {
        String sql = "SELECT * FROM " +table + " WHERE codeUe = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapUe(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UE> getAllUEs() {
        List<UE> ues = new ArrayList<>();
        String sql = "SELECT * FROM " +table ;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ues.add(mapUe(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ues;
    }

    public UE mapUe(ResultSet rs) throws SQLException {
        return new UE(
                rs.getString("codeUe"),
                rs.getString("nom"),
                rs.getInt("nombreHeures")
        );
    }
}
