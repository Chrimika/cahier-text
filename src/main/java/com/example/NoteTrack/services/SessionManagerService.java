package com.example.NoteTrack.services;

import com.example.NoteTrack.entities.User;
import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.ISessionManagerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SessionManagerService implements ISessionManagerService {
    private static final String SESSION_FILE =  "session.json";
    private Map<String, String> activeSessions;

    public SessionManagerService() {
        this.activeSessions = new HashMap<>();
        loadSessions();
    }

    @Override
    public void saveSessions() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(SESSION_FILE), activeSessions);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement des sessions : " + e.getMessage());
        }
    }

    @Override
    public void loadSessions() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(SESSION_FILE);
            if (file.exists()) {
                activeSessions = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {
                });
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des sessions : " + e.getMessage());
        }
    }

    @Override
    public void addSession(String token, String username) {
        activeSessions.put(token, username);
        saveSessions();
    }

    @Override
    public String getUtilisateurAuthentifier()
    {
        if(activeSessions.isEmpty())
        {
            return null;
        }

       return activeSessions.values().iterator().next();
    }



    @Override
    public void removeSession(String token) {
        activeSessions.remove(token);
        saveSessions();
    }


    @Override
    public boolean isAuthenticated(String token) {
        return activeSessions.containsKey(token);
    }
}
