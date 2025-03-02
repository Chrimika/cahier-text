package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.dao.NiveauDao;
import com.example.NoteTrack.entities.Niveau;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.INiveauDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.INiveauService;

import java.sql.SQLException;
import java.util.List;

public class NiveauService implements INiveauService {

    private INiveauDao niveauDao;

    public NiveauService() throws SQLException
    {
        niveauDao = new NiveauDao(ConnectionService.getInstance().getConnection());
    }

    @Override
    public boolean ajouterNiveau(Niveau niveau) {
        return  niveauDao.ajouterNiveau(niveau);
    }

    @Override
    public boolean modifierNiveau(Niveau niveau) {
        return niveauDao.modifierNiveau(niveau);
    }

    @Override
    public boolean supprimerNiveau(String code) {
        return niveauDao.supprimerNiveau(code);
    }

    @Override
    public Niveau getNiveauByCode(String code) {
        return niveauDao.getNiveauByCode(code);
    }

    @Override
    public List<Niveau> getAllNiveaus() {
        return niveauDao.getAllNiveaux();
    }
}
