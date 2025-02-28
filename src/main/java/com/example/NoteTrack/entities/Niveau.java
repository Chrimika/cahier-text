package com.example.NoteTrack.entities;

public class Niveau {
    private String code;
    private String nom;
    private int id;

    public Niveau(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Niveau(String code, String nom, int id) {
        this.code = code;
        this.nom = nom;
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}