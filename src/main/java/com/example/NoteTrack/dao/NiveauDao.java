package com.example.NoteTrack.dao;

import com.example.NoteTrack.entities.Niveau;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.INiveauDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NiveauDao implements INiveauDao {

    private Connection connection;
    private String table;

    public NiveauDao(Connection connection) {
        this.connection = connection;
        this.table = "Niveau";
    }

    public NiveauDao(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    @Override
    public boolean ajouterNiveau(Niveau niveau) {
        String sql = "INSERT INTO " + table + " (code, nom) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, niveau.getCode());
            stmt.setString(2, niveau.getNom());
           int row = stmt.executeUpdate();
           return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modifierNiveau(Niveau niveau) {
        String sql = "UPDATE " + table + " SET nom = ? WHERE code = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, niveau.getNom());
            stmt.setString(2, niveau.getCode());
          int row =  stmt.executeUpdate();
          return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean supprimerNiveau(int id) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
           int row=  stmt.executeUpdate();
           return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Niveau getNiveauById(int id) {
        String sql = "SELECT * FROM " + table + " WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Niveau(
                        rs.getString("code"),
                        rs.getString("nom"),
                        rs.getInt("id")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Niveau> getAllNiveaux() {
        List<Niveau> niveaux = new ArrayList<>();
        String sql = "SELECT * FROM " + table;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                niveaux.add(new Niveau(
                        rs.getString("code"),
                        rs.getString("nom")
                        , rs.getInt("id")

                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return niveaux;
    }
}
