package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.RoleDao;
import com.example.NoteTrack.dao.UserDao;
import com.example.NoteTrack.entities.Role;
import com.example.NoteTrack.entities.User;
import com.example.NoteTrack.utils.enumarations.RoleEnum;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IRoleDao;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IUserDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IRoleService;
import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.IUserService;
import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.ISessionManagerService;


import java.sql.Connection;
import java.sql.SQLException;

public class UserService implements IUserService {
    private final IUserDao userDao;
    private final IRoleDao roleDao;
    private final ISessionManagerService SessionManager;

    public UserService() throws SQLException {
        ISessionManagerService sessionManager = new SessionManagerService();
        Connection connection = ConnectionService.getInstance().getConnection();
        this.userDao = new UserDao(connection);
        this.roleDao = new RoleDao(connection);
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
    public boolean registerWithRole(User user, RoleEnum role) throws SQLException {
        IRoleService roleService = new RoleService();
        Role roleBd = roleService.getRole(role);
        boolean verifUserInsert = this.register(user);
        if (verifUserInsert) {
            if (userDao.getUser(user.getUsername()) != null) {
                boolean verifRoleAdd = roleDao.ajouterRoleUser(userDao.getUser(user.getUsername()).getId(), roleBd.getId());
                if (verifRoleAdd)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            String token = generateToken(user);
            SessionManager.addSession(token, username);
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

    public static User getUtilisateurAuthentifier() throws SQLException {
        SessionManagerService sessionManagerService = new SessionManagerService();
        IUserService userService = new UserService();
        User user = userService.getUtilisateur(sessionManagerService.getUtilisateurAuthentifier());
        return user;
    }

    private String generateToken(User user) {
        return user.getUsername() + "_" + System.currentTimeMillis();
    }
}
