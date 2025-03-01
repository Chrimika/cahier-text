package com.example.NoteTrack.utils.interfaces.servicesInterface;

import com.example.NoteTrack.entities.Niveau;

import java.util.List;

public interface INiveauService {

    boolean ajouterNiveau(Niveau niveau);

    boolean modifierNiveau(Niveau niveau);

    boolean supprimerNiveau(String code);

    Niveau getNiveauByCode(String code);

    List<Niveau> getAllNiveaus();
}
