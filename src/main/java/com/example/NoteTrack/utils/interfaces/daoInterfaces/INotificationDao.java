package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Notification;

import java.util.List;

public interface INotificationDao {
    void addNotification(Notification notification);

    void updateNotification(Notification notification);

    void deleteNotification(int id);

    Notification getNotificationById(int id);

    List<Notification> getAllNotifications();

    List<Notification> getNotificationsByUser(int userId);
}
