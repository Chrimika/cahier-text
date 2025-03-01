package com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification;

import com.example.NoteTrack.entities.User;

public interface IUserService {

    boolean register(User user);

    User login(String username, String password);

    void logout(String token);

    boolean supprimerUtilisateur(String username);

    User getUtilisateur(String username);

    boolean modifierUtilisateur(User user);


    boolean isAuthenticated(String token);
}