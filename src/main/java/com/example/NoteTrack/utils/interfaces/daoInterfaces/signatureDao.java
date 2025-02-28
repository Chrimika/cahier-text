package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Signature;

import java.util.List;

public interface signatureDao {
    void ajouterSignature(Signature signature);

    void modifierSignature(Signature signature);

    void supprimerSignature(int id);

    Signature getSignatureById(int id);

    List<Signature> getAllSignatures();
}
