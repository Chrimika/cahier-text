package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Notification;

import java.util.List;

public interface INotificationDao {
    boolean addNotification(Notification notification);

    boolean updateNotification(Notification notification);

    boolean deleteNotification(int id);

    Notification getNotificationById(int id);

    List<Notification> getAllNotifications();

    List<Notification> getNotificationsByUser(int userId);
}
