package com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification;

import com.example.NoteTrack.entities.User;
import com.example.NoteTrack.utils.enumarations.RoleEnum;

import java.sql.SQLException;

public interface IUserService {

    boolean register(User user);

    boolean registerWithRole(User user , RoleEnum role) throws SQLException;

    User login(String username, String password);

    void logout(String token);

    boolean supprimerUtilisateur(String username);

    User getUtilisateur(String username);

    boolean modifierUtilisateur(User user);


    boolean isAuthenticated(String token);
}