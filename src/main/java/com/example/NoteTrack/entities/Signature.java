package com.example.NoteTrack.entities;

import java.time.LocalDateTime;
import java.util.Date;

public class Signature {
    private boolean professeurSignature;
    private LocalDateTime dateSignatureProf;
    private int userId;
    private int seanceId;
    private int id ;
    public Signature(int  id ,int userId , int seanceId , boolean professeurSignature , LocalDateTime dateSignatureProf)
    {
        this.professeurSignature = professeurSignature;
        this.userId = userId;
        this.seanceId = seanceId;
        this.dateSignatureProf = dateSignatureProf;
        this.id = id;
    }

    public Signature(boolean professeurSignature , LocalDateTime dateSignatureProf) {
        this.professeurSignature = professeurSignature;

        this.dateSignatureProf = dateSignatureProf;
    }

    // Getters and setters for all fields

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(int seanceId) {
        this.seanceId = seanceId;
    }

    public boolean isProfesseurSignature() {
        return professeurSignature;
    }

    public void setProfesseurSignature(boolean professeurSignature) {
        this.professeurSignature = professeurSignature;
    }


    public LocalDateTime getDateSignatureProf() {
        return dateSignatureProf;
    }

    public void setDateSignatureProf(LocalDateTime dateSignatureProf) {
        this.dateSignatureProf = dateSignatureProf;
    }

}