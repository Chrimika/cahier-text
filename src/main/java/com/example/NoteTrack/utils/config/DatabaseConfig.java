package com.example.NoteTrack.utils.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {
    private String dbURL;
    private String username;
    private String password;

    public DatabaseConfig() {
        loadConfig();
    }

    private void loadConfig() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            this.dbURL = properties.getProperty("db.url");
            this.username = properties.getProperty("db.username");
            this.password = properties.getProperty("db.password");
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement du fichier de configuration !");
            e.printStackTrace();
        }
    }

    public String getDbURL() {
        return dbURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
