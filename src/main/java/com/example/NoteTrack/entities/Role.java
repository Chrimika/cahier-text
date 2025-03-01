package com.example.NoteTrack.entities;

import com.example.NoteTrack.utils.enumarations.RoleEnum;

public class Role {
    private String descriptionRole;
    private RoleEnum role;
    private int id;

    public Role(String descriptionRole, RoleEnum role)
    {
        this.descriptionRole = descriptionRole;
        this.role = role;
    }
    public Role(String descriptionRole, RoleEnum role, int id)
    {
        this.descriptionRole = descriptionRole;
        this.role = role;
        this.id = id;
    }

    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public RoleEnum getRole() {
        return role;
    }

    public String getDescriptionRole() {
        return descriptionRole;
    }

    public void setDescriptionRole(String descriptionRole) {
        this.descriptionRole = descriptionRole;
    }
}
