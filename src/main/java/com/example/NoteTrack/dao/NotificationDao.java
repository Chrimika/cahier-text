package com.example.NoteTrack.dao;

import com.example.NoteTrack.entities.Notification;
import com.example.NoteTrack.utils.enumarations.NotificationStatus;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.INotificationDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDao implements INotificationDao {

    private Connection connection;
    private String table;

    public NotificationDao(Connection connection) {
        this.connection = connection;
        this.table = "Notification";
    }

    public NotificationDao(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    @Override
    public void addNotification(Notification notification) {
        String sql = "INSERT INTO " + table + " (message, dateEnvoi,dateLecture, estLue, userId ,type) VALUES (?, ?,?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, notification.getMessage());
            stmt.setTimestamp(2, Timestamp.valueOf(notification.getDateEnvoi()));
            stmt.setTimestamp(3, Timestamp.valueOf(notification.getDateLecture()));
            stmt.setBoolean(4, notification.isLu());
            stmt.setInt(5, notification.getUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateNotification(Notification notification) {
        String sql = "UPDATE " + table + " SET message = ?, dateEnvoi = ?, dateLecture = ? ,estLue = ?, userId = ?  WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, notification.getMessage());
            stmt.setTimestamp(2, Timestamp.valueOf(notification.getDateEnvoi().toString()));
            stmt.setTimestamp(3, Timestamp.valueOf(notification.getDateLecture().toString()));
            stmt.setBoolean(4, notification.isLu());
            stmt.setInt(5, notification.getUserId());
            stmt.setInt(6, notification.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNotification(int id) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Notification getNotificationById(int id) {
        String sql = "SELECT * FROM " + table + " WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                mapNotification(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Notification> getAllNotifications() {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM " + table;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                notifications.add(mapNotification(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notifications;
    }

    @Override
    public List<Notification> getNotificationsByUser(int userId) {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " WHERE userId = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notifications.add(mapNotification(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notifications;
    }

    public Notification mapNotification(ResultSet rs) throws SQLException {
        String type = rs.getString("type");
        NotificationStatus typeModel = null;
        switch (type) {
            case "info":
                typeModel = NotificationStatus.INFO;
                break;

            case "warning":
                typeModel = NotificationStatus.WARNING;
                break;

            case "error":
                typeModel = NotificationStatus.ERROR;
                break;
        }
        return new Notification(
                rs.getInt("id"),
                rs.getInt("userId"),
                rs.getString("message"),
                rs.getBoolean("lu"),
                rs.getTimestamp("dateEnvoi").toLocalDateTime(),
                rs.getTimestamp("dateEnvoi").toLocalDateTime(),
                typeModel
        );
    }
}
