package com.example.NoteTrack.services;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.dao.RoleDao;
import com.example.NoteTrack.entities.Role;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.enumarations.RoleEnum;
import com.example.NoteTrack.utils.interfaces.daoInterfaces.IRoleDao;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IRoleService;

import java.sql.SQLException;
import java.util.List;

public class RoleService implements IRoleService {

    private IRoleDao roleDao;

    public RoleService() throws SQLException
    {
        DatabaseConfig config = new DatabaseConfig();
        roleDao = new RoleDao(ConnectionDao.getInstance(config).getConnection());
    }
    @Override
    public boolean ajouterRole(Role role) {
        return roleDao.ajouterRole(role);
    }

    @Override
    public boolean modifierRole(Role role) {
        return roleDao.modifierRole(role);
    }

    @Override
    public boolean supprimerRole(Role role) {
        return roleDao.supprimerRole(role);
    }

    @Override
    public boolean supprimerAllRole()
    {
        return roleDao.supprimerAllRole();
    }

    @Override
    public Role getRole(RoleEnum nameRole) {
        return roleDao.getRole(nameRole);
    }

    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    @Override
    public List<Role> getRolesForUser(int userId) {
        return roleDao.getRolesForUser(userId);
    }
}
