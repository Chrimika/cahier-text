package com.example.NoteTrack.dao;

import com.example.NoteTrack.entities.User;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IRoleDao;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IUserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {

    private Connection connection;
    private String table;

    public UserDao(Connection connection) {
        this.connection = connection;
        this.table = "User";
    }

    public UserDao(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    @Override
    public User getUser(String username) {
        String sql = "SELECT * FROM " + table + " WHERE username = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM " + table;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(mapUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO " + table + " (username, password, email, nom, prenom) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getNom());
            stmt.setString(5, user.getPrenom());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE " + table + " SET password = ?, email = ?, nom = ?, prenom = ? WHERE username = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getNom());
            stmt.setString(4, user.getPrenom());
            stmt.setString(5, user.getUsername());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String username) {
        String sql = "DELETE FROM " + table + " WHERE username = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User mapUser(ResultSet rs) throws SQLException {
        User user = new User(
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getInt("id")
        );
        IRoleDao role = new RoleDao(connection);
        user.addAllRole(role.getRolesForUser(user.getId()));
        return user;
    }
}
