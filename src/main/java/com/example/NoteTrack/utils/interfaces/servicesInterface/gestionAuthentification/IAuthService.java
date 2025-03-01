package com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification;

import com.example.NoteTrack.entities.User;

public interface IAuthService {

//    boolean register(User user);

    User login(String username, String password);

    void logout(String token);

    boolean isAuthenticated(String token);
}