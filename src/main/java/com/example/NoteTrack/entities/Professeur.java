package com.example.NoteTrack.entities;

import com.example.NoteTrack.utils.enumarations.RoleEnum;

public class Professeur extends User {
    public Professeur(String username, String password, String email, String nom, String prenom) {
        super(username, password, email, nom, prenom, RoleEnum.PROFESSEUR);
    }
}
