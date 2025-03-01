package com.example.NoteTrack.dao;

import com.example.NoteTrack.entities.Filiere;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IFiliereDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FiliereDao implements IFiliereDao {
    private Connection connection;
    private String table;

    public FiliereDao(Connection connection) {
            this.connection = connection;
            this.table = "Filiere";
    }


    public FiliereDao(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }


    @Override
    public boolean ajouterFiliere(Filiere filiere) {
        String sql = "INSERT INTO " + table + " (codeFiliere, nom, description) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, filiere.getCode());
            stmt.setString(2, filiere.getNom());
            stmt.setString(3, filiere.getDescription());
            int row =  stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modifierFiliere(Filiere filiere) {
        String sql = "UPDATE " + table + " SET nom = ?, description = ? , codeFiliere = ? WHERE codeFiliere = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, filiere.getNom());
            stmt.setString(2, filiere.getDescription());
            stmt.setString(3, filiere.getCode());
            stmt.setString(4, filiere.getCode());

            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public boolean supprimerFiliere(String code) {
        String sql = "DELETE FROM " + table + " WHERE codeFiliere = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, code);
           int row =  stmt.executeUpdate();
           return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Filiere getFiliereByCode(String code) {
        String sql = "SELECT * FROM " + table + " WHERE codeFiliere = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapFiliere(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Filiere> getAllFilieres() {
        List<Filiere> filieres = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                filieres.add(mapFiliere(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filieres;
    }

    public Filiere mapFiliere(ResultSet rs) throws SQLException {
        return new Filiere(
                rs.getString("codeFiliere"),
                rs.getString("nom"),
                rs.getString("description")
        );
    }
}
