package com.example.NoteTrack.utils.interfaces.entitieInterface;

public interface IAuthentifiable {
    int getId();
    void setId(int id);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    String getEmail();
    void setEmail(String email);
}
