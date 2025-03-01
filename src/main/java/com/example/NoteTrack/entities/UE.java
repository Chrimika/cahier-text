package com.example.NoteTrack.entities;

public class UE {
    private String code;
    private String nom;
    private int nombreHeures;
    private String codeNiveau;

    public UE(String code, String nom, int nombreHeures) {
        this.code = code;
        this.nom = nom;
        this.nombreHeures = nombreHeures;
    }

    public UE(String code, String nom, int nombreHeures , String codeNiveau) {
        this.code = code;
        this.nom = nom;
        this.nombreHeures = nombreHeures;
        this.codeNiveau = codeNiveau;
    }

    public String getCodeNiveau()
    {
        return this.getCodeNiveau();
    }

    public void setCodeNiveau(String codeNiveau)
    {
        this.codeNiveau = codeNiveau;
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