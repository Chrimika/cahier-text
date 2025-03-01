package com.example.NoteTrack.utils.interfaces.entitieInterface;

import com.example.NoteTrack.entities.Role;
import java.util.List;

public interface IRoleManager {
    List<Role> getRoles();
    void addRole(Role role);
    void addAllRole(List<Role> roles);
    void removeRole(Role role);
}
