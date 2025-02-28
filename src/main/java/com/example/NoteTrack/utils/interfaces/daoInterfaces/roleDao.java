package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.Role;
import com.example.NoteTrack.utils.enumarations.RoleEnum;

import java.util.List;

public interface roleDao {
    boolean ajouterRole(Role role);
    boolean modifierRole(Role role);
    boolean supprimerRole(Role role);
    Role getRole(RoleEnum nameRole);
    List<Role> getAllRole();
}
