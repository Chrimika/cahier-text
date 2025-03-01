package com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification;

import com.example.NoteTrack.entities.User;

public interface IUserService {
    void ajouterUtilisateur(User user);

    void modifierUtilisateur(User user);

    void supprimerUtilisateur(String username);

    User getUtilisateur(String username);
}
