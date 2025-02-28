package com.example.NoteTrack.utils.interfaces.entitieInterface;

import com.example.NoteTrack.entities.Role;

import java.util.List;

public interface IUser {
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    String getEmail();
    void setEmail(String email);
    String getNom();
    void setNom(String nom);
    String getPrenom();
    void setPrenom(String prenom);
    int getId();
    void setId(int id);
    List<Role> getRole();
    void setRole(Role role);
}