package com.example.NoteTrack.entities;

public class UE {
    private String code;
    private String nom;
    private int nombreHeures;
    private int id;

    public UE(String code, String nom, int nombreHeures, int id) {
        this.code = code;
        this.nom = nom;
        this.nombreHeures = nombreHeures;
        this.id = id;
    }

    public UE(String code, String nom, int nombreHeures) {
        this.code = code;
        this.nom = nom;
        this.nombreHeures = nombreHeures;
    }

    public String getNom() {
        return nom;
    }

    public int getNombreHeures() {
        return nombreHeures;
    }

    public String getCode() {
        return code;
    }

    public void setNombreHeures(int nombreHeures) {
        this.nombreHeures = nombreHeures;
    }
}