package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.UE;

import java.util.List;

public interface IUeDao {
    boolean ajouterUE(UE ue);

    boolean modifierUE(UE ue);

    boolean supprimerUE(String code);

    UE getUEBycode(String code);

    List<UE> getAllUEs();
}
