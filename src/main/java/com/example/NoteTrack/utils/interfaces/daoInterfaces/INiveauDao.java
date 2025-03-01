package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Niveau;

import java.util.List;

public interface INiveauDao {

    boolean ajouterNiveau(Niveau niveau);

    boolean modifierNiveau(Niveau niveau);

    boolean supprimerNiveau(int id);

    Niveau getNiveauById(int id);

    List<Niveau> getAllNiveaux();
}
