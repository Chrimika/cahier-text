package com.example.NoteTrack.dao;

import com.example.NoteTrack.entities.UE;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.ueDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ueDaoImpl implements ueDao {

    private Connection connection;
    private String table;

    public ueDaoImpl(Connection connection) {
        this.connection = connection;
        this.table = "UE";
    }

    public ueDaoImpl(Connection connection,String table) {
        this.connection = connection;
        this.table = table;
    }

    @Override
    public void ajouterUE(UE ue) {
        String sql = "INSERT INTO " +table + " (code, nom, nombreHeures) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ue.getCode());
            stmt.setString(2, ue.getNom());
            stmt.setInt(3, ue.getNombreHeures());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierUE(UE ue) {
        String sql = "UPDATE " +table + " SET nom = ?, nombreHeures = ? WHERE code = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ue.getNom());
            stmt.setInt(2, ue.getNombreHeures());
            stmt.setString(3, ue.getCode());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerUE(int id) {
        String sql = "DELETE FROM " +table + " WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UE getUEById(int id) {
        String sql = "SELECT * FROM " +table + " WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new UE(
                        rs.getString("code"),
                        rs.getString("nom"),
                        rs.getInt("nombreHeures")
                        , rs.getInt("id")

                );
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
                ues.add(new UE(
                        rs.getString("code"),
                        rs.getString("nom"),
                        rs.getInt("nombreHeures"),
                        rs.getInt("id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ues;
    }
}
