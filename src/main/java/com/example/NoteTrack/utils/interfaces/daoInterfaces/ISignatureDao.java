package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Signature;

import java.util.List;

public interface ISignatureDao {
    boolean ajouterSignature(Signature signature);

    boolean modifierSignature(Signature signature);

    boolean supprimerSignature(int id);

    Signature getSignatureById(int id);

    List<Signature> getAllSignatures();
}
