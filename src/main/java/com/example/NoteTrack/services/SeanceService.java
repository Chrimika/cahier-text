package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.SeanceDao;
import com.example.NoteTrack.entities.Seance;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.ISeanceDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.ISeanceService;

import java.sql.SQLException;
import java.util.List;

public class SeanceService implements ISeanceService {
    private ISeanceDao seanceDao;

    public SeanceService() throws SQLException
    {
        seanceDao = new SeanceDao(ConnectionService.getInstance().getConnection());
    }

    @Override
    public boolean AjouterNouvelleSeance(Seance seance) {
        return seanceDao.addSeance(seance);
    }

    @Override
    public boolean ModifierSeance(Seance seance) {
        return seanceDao.updateSeance(seance);
    }

    @Override
    public boolean SupprimerSeance(int id) {
        return seanceDao.deleteSeance(id);
    }

    @Override
    public Seance getSeanceById(int id) {
        return seanceDao.getSeanceById(id);
    }

    @Override
    public List<Seance> getAllSeances() {
        return seanceDao.getAllSeances();
    }
}
