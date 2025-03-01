package com.example.NoteTrack.utils.interfaces.servicesInterface;

import com.example.NoteTrack.entities.Role;
import com.example.NoteTrack.utils.enumarations.RoleEnum;

import java.util.List;

public interface IRoleService {
    boolean ajouterRole(Role role);
    boolean modifierRole(Role role);
    boolean supprimerRole(Role role);
    boolean supprimerAllRole();
    Role getRole(RoleEnum nameRole);
    List<Role> getAllRole();
    List<Role> getRolesForUser(int userId);
}
