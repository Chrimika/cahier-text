package com.example.NoteTrack.utils.interfaces.daoInterfaces;

import com.example.NoteTrack.entities.User;

import java.util.List;

public interface IUserDao {
    User getUser(String username);

    List<User> getAllUsers();

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(String username);
}
