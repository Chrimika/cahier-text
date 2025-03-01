package com.example.NoteTrack.entities;

public class Niveau {
    private String code;
    private String nom;
    private String codeFiliere;

    public Niveau(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Niveau(String code, String nom, String codeFiliere)
    {
        this.code = code;
        this.nom = nom;
        this.codeFiliere = codeFiliere;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
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