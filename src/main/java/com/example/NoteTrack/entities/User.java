package com.example.NoteTrack.entities;

import com.example.NoteTrack.utils.interfaces.entitieInterface.IAuthentifiable;
import com.example.NoteTrack.utils.interfaces.entitieInterface.IEntiteDb;
import com.example.NoteTrack.utils.interfaces.entitieInterface.IPersonne;
import com.example.NoteTrack.utils.interfaces.entitieInterface.IRoleManager;

import java.util.ArrayList;
import java.util.List;

public class User implements IAuthentifiable, IPersonne, IRoleManager, IEntiteDb {
    private int id;
    private String username;
    private String password;
    private String email;
    private String nom;
    private String prenom;

    private List<Role> roles = new ArrayList<>();

    // Constructeur
    public User(String username, String password, String email, String nom, String prenom) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }
    public User(String username, String password, String email, String nom, String prenom ,int id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }

    // Implémentation de IAuthentifiable
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    // Implémentation de IPersonne
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getPrenom() {
        return prenom;
    }

    @Override
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Implémentation de IRoleManager (DIP appliqué via un service)
    @Override
    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public void addRole(Role role) {
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }

    @Override
    public void addAllRole(List<Role> roles)
    {
        this.roles =  roles;
    }
    @Override
    public void removeRole(Role role) {
        roles.remove(role);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
