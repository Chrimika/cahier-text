package com.example.NoteTrack.utils.interfaces.servicesInterface;

import com.example.NoteTrack.entities.Seance;

import java.util.List;

public interface ISeanceService {
    boolean AjouterNouvelleSeance(Seance seance);

    boolean ModifierSeance(Seance seance);

    boolean SupprimerSeance(int id);

    Seance getSeanceById(int id);

    List<Seance> getAllSeances();
}
