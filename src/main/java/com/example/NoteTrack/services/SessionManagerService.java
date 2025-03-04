package com.example.NoteTrack.services;

import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.ISessionManagerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SessionManagerService implements ISessionManagerService {
    private static final String SESSION_FILE_NAME = "session.json";
    private final File sessionFile; // Fichier local pour l'écriture
    private Map<String, String> activeSessions;

    public SessionManagerService() {
        // Déterminer un emplacement writable (exemple : dossier utilisateur)
        String userHome = System.getProperty("user.home");
        this.sessionFile = new File(Paths.get(userHome, ".NoteTrack", SESSION_FILE_NAME).toString());
        this.activeSessions = new HashMap<>();
        // Créer le dossier s'il n'existe pas
        File parentDir = sessionFile.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        loadSessions();
    }

    @Override
    public void saveSessions() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(sessionFile, activeSessions);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement des sessions : " + e.getMessage());
        }
    }

    @Override
    public void loadSessions() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (sessionFile.exists()) {
                activeSessions = objectMapper.readValue(sessionFile, new TypeReference<Map<String, String>>() {});
            } else {
                // Optionnel : charger une version par défaut depuis les ressources
                loadDefaultFromResources();
            }
        } catch (IOException e) {
            System.err.println("Erreurs lors du chargement des sessions : " + e.getMessage());
        }
    }

    private void loadDefaultFromResources() {
        try {
            // Charger depuis src/main/resources si nécessaire
            java.net.URL resource = getClass().getResource("/com/example/NoteTrack/" + SESSION_FILE_NAME);
            if (resource != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                activeSessions = objectMapper.readValue(resource, new TypeReference<Map<String, String>>() {});
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement par défaut : " + e.getMessage());
        }
    }

    @Override
    public void addSession(String token, String username) {
        activeSessions.put(token, username);
        saveSessions();
    }

    @Override
    public String getUtilisateurAuthentifier() {
        if (activeSessions.isEmpty()) {
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