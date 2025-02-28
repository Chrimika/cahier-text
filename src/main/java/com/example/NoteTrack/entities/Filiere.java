package com.example.NoteTrack.entities;

public class Filiere {
    private String code;
    private String nom;
    private String description;
    private int id;

    public Filiere(String code, String nom, String description) {
        this.code = code;
        this.nom = nom;
        this.description = description;

    }

    public Filiere(String code, String nom, String description, int id) {
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
