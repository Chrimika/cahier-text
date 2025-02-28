package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Filiere;

import java.util.List;

public interface filiereDao {
    void ajouterFiliere(Filiere filiere);

    void modifierFiliere(Filiere filiere);

    void supprimerFiliere(int id);

    Filiere getFiliereById(int id);

    List<Filiere> getAllFilieres();
}
