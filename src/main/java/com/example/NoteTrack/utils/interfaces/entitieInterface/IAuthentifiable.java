package com.example.NoteTrack.utils.interfaces.entitieInterface;

public interface IAuthentifiable {
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    String getEmail();
    void setEmail(String email);
}
