package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.dao.UserDao;
import com.example.NoteTrack.entities.User;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IUserDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.IUserService;
import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.ISessionManagerService;

import java.sql.SQLException;

public class UserService implements IUserService {
    private final IUserDao userDao;
    private final ISessionManagerService SessionManager;

    public UserService() throws SQLException {
        DatabaseConfig config = new DatabaseConfig();
        ISessionManagerService sessionManager = new SessionManagerService();
        this.userDao = new UserDao(ConnectionDao.getInstance(config).getConnection());
        this.SessionManager = sessionManager;
    }

    @Override
    public boolean register(User user) {

        if (userDao.getUser(user.getUsername()) == null) {
            userDao.addUser(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            String token = generateToken(user);
            SessionManager.addSession(token, user);
            return user;
        }
        return null;
    }

    @Override
    public void logout(String token) {
        SessionManager.removeSession(token);
    }

    @Override
    public boolean supprimerUtilisateur(String username) {
        return userDao.deleteUser(username);
    }

    @Override
    public User getUtilisateur(String username) {
        return userDao.getUser(username);
    }

    @Override
    public boolean modifierUtilisateur(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean isAuthenticated(String token) {
        return SessionManager.isAuthenticated(token);
    }

    public static User getUtilisateurAuthentifier()
    {
        SessionManagerService sessionManagerService = new SessionManagerService();
        return sessionManagerService.getUtilisateurAuthentifier();
    }
    private String generateToken(User user) {
        return user.getUsername() + "_" + System.currentTimeMillis();
    }
}
