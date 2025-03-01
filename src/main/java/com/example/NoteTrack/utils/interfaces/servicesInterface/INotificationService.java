package com.example.NoteTrack.utils.interfaces.servicesInterface;

import com.example.NoteTrack.entities.Notification;

import java.util.List;

public interface INotificationService {
    boolean addNotification(Notification notification);

    boolean updateNotification(Notification notification);

    boolean deleteNotification(int id);

    Notification getNotificationById(int id);

    List<Notification> getAllNotifications();

    List<Notification> getNotificationsByUser(int userId);
}
