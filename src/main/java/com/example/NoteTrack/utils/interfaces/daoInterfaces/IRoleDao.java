package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Role;
import com.example.NoteTrack.entities.User;
import com.example.NoteTrack.utils.enumarations.RoleEnum;

import java.util.List;

public interface IRoleDao {
    boolean ajouterRole(Role role);
    boolean modifierRole(Role role);
    boolean ajouterRoleUser(int idUser , int idRole);
    boolean supprimerRole(Role role);
    boolean supprimerAllRole();
    Role getRole(RoleEnum nameRole);
    List<Role> getAllRole();
    List<Role> getRolesForUser(int userId);

}
