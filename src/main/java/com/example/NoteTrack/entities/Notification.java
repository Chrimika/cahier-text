package com.example.NoteTrack.entities;

import com.example.NoteTrack.utils.enumarations.NotificationStatus;

import java.time.LocalDateTime;

public class Notification {

    private int id;
    private int userId;
    private String message;
    private boolean lu;
    private LocalDateTime dateLecture;
    private LocalDateTime dateEnvoi;
    private NotificationStatus type;



    public Notification(String message, boolean lu, LocalDateTime dateLecture, LocalDateTime dateEnvoi, NotificationStatus type) {
        this.message = message;
        this.lu = lu;
        this.dateLecture = dateLecture;
        this.dateEnvoi = dateEnvoi;
        this.type = type;
    }

    public Notification(int id, int userId, String message, boolean lu, LocalDateTime dateLecture, LocalDateTime dateEnvoi, NotificationStatus type) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.lu = lu;
        this.dateLecture = dateLecture;
        this.dateEnvoi = dateEnvoi;
        this.type = type;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isLu() {
        return lu;
    }

    public void setLu(boolean lu) {
        this.lu = lu;
    }

    public LocalDateTime getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDateTime dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public LocalDateTime getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(LocalDateTime dateLecture) {
        this.dateLecture = dateLecture;
    }

    public NotificationStatus getType() {
        return type;
    }

    public void setType(NotificationStatus type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                ", lu=" + lu +
                ", dateLecture=" + dateLecture +
                ", dateEnvoi=" + dateEnvoi +
                ", type=" + type +
                '}';
    }
}
