package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.dao.FiliereDao;
import com.example.NoteTrack.entities.Filiere;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IFiliereDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IConnectionService;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IFiliereService;

import java.sql.SQLException;
import java.util.List;

public class FiliereService implements IFiliereService {
    private final IFiliereDao filiereDao;

    public FiliereService() throws SQLException
    {
        filiereDao = new FiliereDao(ConnectionService.getInstance().getConnection());
    }

    @Override
    public boolean ajouterFiliere(Filiere filiere) {
        return filiereDao.ajouterFiliere(filiere);
    }

    @Override
    public boolean modifierFiliere(Filiere filiere) {
        return filiereDao.modifierFiliere(filiere);
    }

    @Override
    public boolean supprimerFiliere(String code) {
        return filiereDao.supprimerFiliere(code);
    }

    @Override
    public Filiere getFiliereByCode(String code) {
        return filiereDao.getFiliereByCode(code);
    }

    @Override
    public List<Filiere> getAllFilieres() {
        return filiereDao.getAllFilieres();
    }
}
