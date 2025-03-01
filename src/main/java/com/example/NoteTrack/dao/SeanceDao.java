package com.example.NoteTrack.dao;

import com.example.NoteTrack.entities.Seance;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.ISeanceDao;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeanceDao implements ISeanceDao {

    private final Connection connection;
    private final String table;

    public SeanceDao(Connection connection) {
        this.connection = connection;
        this.table = "Seance";
    }

    public SeanceDao(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    @Override
    public boolean addSeance(Seance seance) {
        String sql = "INSERT INTO " + table + " (date, heureDebut, heureFin, duree,titreLecon, codeNiveau, codeUe) VALUES (?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(seance.getDateCours().toString()));
            stmt.setTime(2, Time.valueOf(seance.getHeureDebut()));
            stmt.setTime(3, Time.valueOf(seance.getHeureFin()));
            stmt.setInt(4, seance.getDuree());
            stmt.setString(5, seance.getTitreLecon());
            stmt.setString(6, seance.getCodeNiveau());
            stmt.setString(7, seance.getCodeUe());
            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean updateSeance(Seance seance) {
        String sql = "UPDATE " + table + " SET date = ?, heureDebut = ?, heureFin = ?, duree = ?,titreLecon = ? ,codeNiveau = ?, codeUe = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(seance.getDateCours().toString()));
            stmt.setTime(2, Time.valueOf(seance.getHeureDebut()));
            stmt.setTime(3, Time.valueOf(seance.getHeureFin()));
            stmt.setInt(4, seance.getDuree());
            stmt.setString(5, seance.getTitreLecon());
            stmt.setString(6, seance.getCodeNiveau());
            stmt.setString(7, seance.getCodeUe());
            stmt.setInt(8 , seance.getId());
            int row = stmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean deleteSeance(int id) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";

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
    public Seance getSeanceById(int id) {
        String sql = "SELECT * FROM " + table + " WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapSeance(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Seance> getAllSeances() {
        List<Seance> seances = new ArrayList<>();
        String sql = "SELECT * FROM " + table;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                seances.add(
                        mapSeance(rs)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seances;
    }

    public Seance mapSeance(@NotNull ResultSet rs) throws SQLException {
        return new Seance(
                rs.getInt("id"),
                rs.getDate("dateCours"),
                rs.getTime("heureDebut").toLocalTime(),
                rs.getTime("heureFin").toLocalTime(),
                rs.getInt("duree"),
                rs.getString("titreLecon"),
                rs.getString("contenue"),
                rs.getString("codeNiveau"),
                rs.getString("codeUe"),
                rs.getInt("idSignature")

        );

    }
}
