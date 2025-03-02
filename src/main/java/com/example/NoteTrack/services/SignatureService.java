package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.dao.SignatureDao;
import com.example.NoteTrack.entities.Signature;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.ISignatureDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.ISignatureService;

import java.sql.SQLException;
import java.util.List;

public class SignatureService implements ISignatureService {

    private ISignatureDao signatureDao;

    public SignatureService() throws SQLException
    {
        signatureDao = new SignatureDao(ConnectionService.getInstance().getConnection());
    }
    @Override
    public boolean ajouterSignature(Signature signature) {
        return signatureDao.ajouterSignature(signature);
    }

    @Override
    public boolean modifierSignature(Signature signature) {
        return signatureDao.modifierSignature(signature);
    }

    @Override
    public boolean supprimerSignature(int id) {
        return signatureDao.supprimerSignature(id);
    }

    @Override
    public Signature getSignatureById(int id) {
        return signatureDao.getSignatureById(id);
    }

    @Override
    public List<Signature> getAllSignatures() {
        return signatureDao.getAllSignatures();
    }
}
