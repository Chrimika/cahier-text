package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Seance;

import java.util.List;

public interface ISeanceDao {
    void addSeance(Seance seance);

    void updateSeance(Seance seance);

    void deleteSeance(int id);

    Seance getSeanceById(int id);

    List<Seance> getAllSeances();
}
