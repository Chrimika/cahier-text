package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Filiere;

import java.util.List;

public interface IFiliereDao {
    boolean ajouterFiliere(Filiere filiere);

    boolean modifierFiliere(Filiere filiere);

    boolean supprimerFiliere(String code);

    Filiere getFiliereByCode(String code);

    List<Filiere> getAllFilieres();
}
