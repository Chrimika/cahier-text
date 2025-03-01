package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Niveau;

import java.util.List;

public interface INiveauDao {

    boolean ajouterNiveau(Niveau niveau);

    boolean modifierNiveau(Niveau niveau);

    boolean supprimerNiveau(String  code);

    Niveau getNiveauByCode(String code);

    List<Niveau> getAllNiveaux();
}
