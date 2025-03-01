package com.example.NoteTrack.dao;

import com.example.NoteTrack.entities.Role;
import com.example.NoteTrack.utils.enumarations.RoleEnum;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IRoleDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao implements IRoleDao {
    private Connection connection;
    private String table;

    public RoleDao(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    public RoleDao(Connection connection) {
        this.connection = connection;
        this.table = "role";
    }

    @Override
    public boolean ajouterRole(Role role) {
        String sql = "INSERT INTO " + table + " (nom, description) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, role.getRole().toString()); // Store the enum name as a string
            stmt.setString(2, role.getDescriptionRole());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Returns true if at least one row was added.
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false when an exception is catched.
        }
    }

    @Override
    public boolean modifierRole(Role role) { //Included missing description
        String sql = "UPDATE " + table + " SET description = ? WHERE nom = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, role.getDescriptionRole());
            stmt.setString(2, role.getRole().toString());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; //Return True if at least one row was updated
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerRole(Role role) {
        String sql = "DELETE FROM " + table + " WHERE nom = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, role.getRole().toString());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerAllRole() {
        String sql ="DELETE FROM "+ table ;
        try(Statement stmt  = connection.createStatement()) {
            int row = stmt.executeUpdate(sql);
            return row > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Role getRole(RoleEnum role) {
        String sql = "SELECT description FROM " + table + " WHERE nom = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, role.name());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //Role was found
                    return mapRole(rs);
                } else {
                    //Role was not found
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Role> getAllRole() {
        String sql = "Select * from " + table;
        List<Role> roles = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                roles.add(mapRole(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            ;
        }
        return  roles;
    }

    @Override
    public List<Role> getRolesForUser(int userId) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT r.id, r.nom , r.description FROM "+table+" r " +
                "JOIN roleUtilisateur ur ON r.id = ur.role_id " +
                "WHERE ur.user_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                roles.add(mapRole(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;

    }

    public Role mapRole(ResultSet rs) throws SQLException {
        return new Role(rs.getString("description"), RoleEnum.valueOf(rs.getString("nom")), rs.getInt("id"));
    }
}