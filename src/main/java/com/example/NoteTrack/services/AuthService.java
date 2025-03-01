package com.example.NoteTrack.services;

import com.example.NoteTrack.entities.User;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IUserDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.IAuthService;
import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.ISessionManagerService;

public class AuthService implements IAuthService {
    private IUserDao userDao;
    private ISessionManagerService SessionManager;

    public AuthService(IUserDao userDao, ISessionManagerService sessionManager) {
        this.userDao = userDao;
        this.SessionManager = sessionManager;
    }

//    @Override
//    public boolean register(User user) {
//        if (UserDao.getUser(user.getUsername()) == null) {
//            UserDao.addUser(user);
//            return true;
//        }
//        return false;
//    }

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
    public boolean isAuthenticated(String token) {
        return SessionManager.isAuthenticated(token);
    }

    private String generateToken(User user) {
        return user.getUsername() + "_" + System.currentTimeMillis();
    }
}
