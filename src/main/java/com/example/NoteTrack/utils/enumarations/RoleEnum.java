package com.example.NoteTrack.utils.enumarations;

public enum RoleEnum {
    ADMINISTRATEUR("Administrateur du système, possède tous les droits."),
    PROFESSEUR("Enseignant, responsable de la dispensation des cours."),
    DELEGUE("Représentant des étudiants.");

    private final String description;

    RoleEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}