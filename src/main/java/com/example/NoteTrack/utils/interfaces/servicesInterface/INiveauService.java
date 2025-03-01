package com.example.NoteTrack.utils.interfaces.servicesInterface;

import com.example.NoteTrack.entities.Niveau;

import java.util.List;

public interface INiveauService {

    boolean ajouterNiveau(Niveau niveau);

    boolean modifierNiveau(Niveau niveau);

    boolean supprimerNiveau(int id);

    Niveau getNiveauById(int id);

    List<Niveau> getAllNiveaus();
}
