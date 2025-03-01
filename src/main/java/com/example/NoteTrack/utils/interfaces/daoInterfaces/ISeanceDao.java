package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Seance;

import java.util.List;

public interface ISeanceDao {
    boolean addSeance(Seance seance);

    boolean updateSeance(Seance seance);

    boolean deleteSeance(int id);

    Seance getSeanceById(int id);

    List<Seance> getAllSeances();
}
