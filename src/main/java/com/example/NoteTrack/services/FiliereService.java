package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.dao.FiliereDao;
import com.example.NoteTrack.entities.Filiere;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IFiliereDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IFiliereService;

import java.sql.SQLException;
import java.util.List;

public class FiliereService implements IFiliereService {
    private final IFiliereDao filiereDao;

    public FiliereService() throws SQLException
    {
        DatabaseConfig config = new DatabaseConfig();
        filiereDao = new FiliereDao(ConnectionDao.getInstance(config).getConnection());
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
    public boolean supprimerFiliere(int id) {
        return filiereDao.supprimerFiliere(id);
    }

    @Override
    public Filiere getFiliereById(int id) {
        return filiereDao.getFiliereById(id);
    }

    @Override
    public List<Filiere> getAllFilieres() {
        return filiereDao.getAllFilieres();
    }
}
