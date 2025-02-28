package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.User;

import java.util.List;

public interface userDao {
    User getUser(String username);

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(String username);
}
