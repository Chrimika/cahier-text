package com.example.NoteTrack.utils.interfaces.servicesInterface;


import com.example.NoteTrack.entities.UE;

import java.util.List;

public interface IUeService {

    boolean ajouterUniteEnseignement(UE ue);

    boolean modifierUniteEnseignement(UE ue);

    boolean supprimerUniteEnseignement(String code);

    UE getUniteEnseignementByCode(String code);

    List<UE> getAllUniteEnseignements();
}
