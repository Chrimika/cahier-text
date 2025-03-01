package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.UE;

import java.util.List;

public interface IUeDao {
    void ajouterUE(UE ue);

    void modifierUE(UE ue);

    void supprimerUE(int id);

    UE getUEById(int id);

    List<UE> getAllUEs();
}
