package com.example.NoteTrack.entities;

import com.example.NoteTrack.utils.enumarations.RoleEnum;

public class Administrateur extends User{

    public Administrateur(String username, String password, String email, String nom, String prenom) {
        super(username, password, email, nom, prenom, RoleEnum.ADMINISTRATEUR);
    }
}
