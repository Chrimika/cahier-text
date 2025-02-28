package com.example.NoteTrack.entities;

import java.time.LocalTime;
import java.util.Date;

public class Seance {
    private Date dateCours;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private int duree;
    private String titreLecon;
    private int id;
    private int id_niveau;
    private int id_ue;

    public Seance(Date dateCours, LocalTime heureDebut, LocalTime heureFin, int duree, String titreLecon) {
        this.dateCours = dateCours;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.duree = duree;
        this.titreLecon = titreLecon;
    }

    public Seance(int id, Date dateCours, LocalTime heureDebut, LocalTime heureFin, int duree, String titreLecon, int id_niveau, int id_ue) {
        this.dateCours = dateCours;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.duree = duree;
        this.titreLecon = titreLecon;
        this.id = id;
        this.id_niveau = id_niveau;
        this.id_ue = id_ue;
    }

    // Getters and setters for all fields
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

    public int getId_ue() {
        return id_ue;
    }

    public void setId_ue(int id_ue) {
        this.id_ue = id_ue;
    }

    public int getId_niveau() {
        return id_niveau;
    }


    public void setId_niveau(int id_niveau) {
        this.id_niveau = id_niveau;
    }

}
