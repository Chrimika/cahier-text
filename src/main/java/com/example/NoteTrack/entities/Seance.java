package com.example.NoteTrack.entities;

import java.time.LocalTime;
import java.util.Date;

public class Seance {
    private Date dateCours;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private int duree;
    private String titreLecon;
    private String contenue;
    private int id;
    private String codeNiveau;
    private String codeUe;
    private int idSignature;

    public Seance(Date dateCours, LocalTime heureDebut, LocalTime heureFin, int duree, String titreLecon, String contenue) {
        this.dateCours = dateCours;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.duree = duree;
        this.titreLecon = titreLecon;
        this.contenue  = contenue;
    }

    public Seance(int id, Date dateCours, LocalTime heureDebut, LocalTime heureFin, int duree, String titreLecon,String contenue ,String codeNiveau, String codeUe , int idSignature) {
        this.dateCours = dateCours;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.duree = duree;
        this.titreLecon = titreLecon;
        this.id = id;
        this.codeNiveau = codeNiveau;
        this.codeUe = codeUe;
        this.contenue = contenue;
        this.idSignature = idSignature;
    }

    // Getters and setters for all fields


    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public Date getDateCours() {
        return dateCours;
    }

    public void setDateCours(Date dateCours) {
        this.dateCours = dateCours;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getTitreLecon() {
        return titreLecon;
    }

    public void setTitreLecon(String titreLecon) {
        this.titreLecon = titreLecon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeUe() {
        return codeUe;
    }

    public void setCodeUe(String codeUe) {
        this.codeUe = codeUe;
    }

    public String getCodeNiveau() {
        return codeNiveau;
    }


    public void setCodeNiveau(String codeNiveau) {
        this.codeNiveau = codeNiveau;
    }

    public int getIdSignature() {
        return idSignature;
    }

    public void setIdSignature(int idSignature) {
        this.idSignature = idSignature;
    }
}
