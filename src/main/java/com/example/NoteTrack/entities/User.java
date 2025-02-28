package com.example.NoteTrack.entities;

import com.example.NoteTrack.utils.enumarations.RoleEnum;
import com.example.NoteTrack.utils.interfaces.entitieInterface.IUser;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private String username;
    private String password;
    private String email;
    private String nom;
    private String prenom;
    private int id ;
    private List<Role> roles = new ArrayList<>(); // 1. Initialize the list
    //Constructors
    public User(String username, String password, String email, String nom, String prenom , Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.roles.add(role); // Add the role to the list
    }
    public User(String username, String password, String email, String nom, String prenom, Role role, int id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.roles.add(role); // Add the role to the list
    }

    // Getters et setters
    @Override
    public String getUsername() { return username; }
    @Override
    public void setUsername(String username) { this.username = username; }
    @Override
    public String getPassword() { return password; }
    @Override
    public void setPassword(String password) { this.password = password; }
    @Override
    public String getEmail() { return email; }
    @Override
    public void setEmail(String email) { this.email = email; }
    @Override
    public String getNom() { return nom; }
    @Override
    public void setNom(String nom) { this.nom = nom; }
    @Override
    public String getPrenom() { return prenom; }
    @Override
    public void setPrenom(String prenom) { this.prenom = prenom; }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public List<Role> getRole() {
        return roles;
    }
    @Override
    public void setRole(Role role) {
        this.roles.add(role);
    }
}