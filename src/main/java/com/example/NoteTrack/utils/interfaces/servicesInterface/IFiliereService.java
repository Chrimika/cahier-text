package com.example.NoteTrack.utils.interfaces.servicesInterface;

import com.example.NoteTrack.entities.Filiere;

import java.util.List;

public interface IFiliereService {
    boolean ajouterFiliere(Filiere filiere);

    boolean modifierFiliere(Filiere filiere);

    boolean supprimerFiliere(int id);

    Filiere getFiliereById(int id);

    List<Filiere> getAllFilieres();
}
