package com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification;

import com.example.NoteTrack.entities.User;

public interface ISessionManagerService {
    void saveSessions();

    void loadSessions();

    void addSession(String token, User user);

    void removeSession(String token);

    User getUserByToken(String token);

    boolean isAuthenticated(String token);
}
