package com.example.NoteTrack.services;

import com.example.NoteTrack.entities.User;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IUserDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.IUserService;

public class UserService implements IUserService {

    private IUserDao userDao;

    @Override
    public void ajouterUtilisateur(User user) {
        userDao.addUser(user);
    }

    @Override
    public void modifierUtilisateur(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void supprimerUtilisateur(String username) {
        userDao.deleteUser(username);
    }

    @Override
    public User getUtilisateur(String username) {
       return userDao.getUser(username);
    }

}
