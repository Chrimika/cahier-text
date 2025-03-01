package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.dao.NotificationDao;
import com.example.NoteTrack.entities.Notification;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.INotificationDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.INotificationService;

import java.sql.SQLException;
import java.util.List;

public class NotificationService implements INotificationService {

    private INotificationDao notificationDao;

    public NotificationService() throws SQLException
    {
        DatabaseConfig config = new DatabaseConfig();
        notificationDao = new NotificationDao(ConnectionDao.getInstance(config).getConnection());
    }

    @Override
    public boolean addNotification(Notification notification) {
        return notificationDao.addNotification(notification);
    }

    @Override
    public boolean updateNotification(Notification notification) {
        return notificationDao.updateNotification(notification);
    }

    @Override
    public boolean deleteNotification(int id) {
        return notificationDao.deleteNotification(id);
    }

    @Override
    public Notification getNotificationById(int id) {
        return notificationDao.getNotificationById(id);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationDao.getAllNotifications();
    }

    @Override
    public List<Notification> getNotificationsByUser(int userId) {
        return notificationDao.getNotificationsByUser(userId);
    }
}
