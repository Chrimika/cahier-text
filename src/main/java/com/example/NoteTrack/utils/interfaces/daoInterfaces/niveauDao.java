package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Niveau;

import java.util.List;

public interface niveauDao {

    void ajouterNiveau(Niveau niveau);

    void modifierNiveau(Niveau niveau);

    void supprimerNiveau(int id);

    Niveau getNiveauById(int id);

    List<Niveau> getAllNiveaux();
}
