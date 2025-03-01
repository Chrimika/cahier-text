package com.example.NoteTrack.services;

import com.example.NoteTrack.entities.Seance;
import com.example.NoteTrack.utils.interfaces.servicesInterface.ISeanceService;

import java.util.List;

public class SeanceService implements ISeanceService {
    private
    @Override
    public boolean AjouterNouvelleSeance(Seance seance) {
        return false;
    }

    @Override
    public boolean ModifierSeance(Seance seance) {
        return false;
    }

    @Override
    public boolean SupprimerSeance(int id) {
        return false;
    }

    @Override
    public Seance getSeanceById(int id) {
        return null;
    }

    @Override
    public List<Seance> getAllSeances() {
        return List.of();
    }
}
