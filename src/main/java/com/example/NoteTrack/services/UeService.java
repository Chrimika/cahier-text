package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.dao.UeDao;
import com.example.NoteTrack.entities.UE;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IUeDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IUeService;

import java.sql.SQLException;
import java.util.List;

public class UeService implements IUeService {

    private IUeDao ueDao;

    public UeService () throws SQLException
    {
        ueDao = new UeDao(ConnectionService.getInstance().getConnection());
    }
    @Override
    public boolean ajouterUniteEnseignement(UE ue) {
        return ueDao.ajouterUE(ue);
    }

    @Override
    public boolean modifierUniteEnseignement(UE ue) {
        return ueDao.modifierUE(ue);
    }

    @Override
    public boolean supprimerUniteEnseignement(String code) {
        return ueDao.supprimerUE(code);
    }

    @Override
    public UE getUniteEnseignementByCode(String code) {
        return ueDao.getUEBycode(code);
    }

    @Override
    public List<UE> getAllUniteEnseignements() {
        return ueDao.getAllUEs();
    }
}
