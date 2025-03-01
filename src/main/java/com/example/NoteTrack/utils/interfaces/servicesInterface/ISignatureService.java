package com.example.NoteTrack.utils.interfaces.servicesInterface;

import com.example.NoteTrack.entities.Signature;

import java.util.List;

public interface ISignatureService {
    boolean ajouterSignature(Signature signature);

    boolean modifierSignature(Signature signature);

    boolean supprimerSignature(int id);

    Signature getSignatureById(int id);

    List<Signature> getAllSignatures();
}
