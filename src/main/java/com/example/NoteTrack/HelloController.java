package com.example.NoteTrack;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.entities.Filiere;
import com.example.NoteTrack.entities.Role;
import com.example.NoteTrack.services.FiliereService;
import com.example.NoteTrack.services.RoleService;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.enumarations.RoleEnum;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IFiliereService;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IRoleService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    private int count = 0;

    @FXML
    protected void onHelloButtonClick() {
        String text = "Vous avez cliquer " + count + " fois sur le boutton";
//        try {
//            IFiliereService filiereService = new FiliereService();
//            Filiere  filiere = new Filiere("ICT4D","ICT FOR DEVELOPMENT","Filiere informatique de developement");
//            filiereService.ajouterFiliere(filiere);
//
//            text = "L'ajout c'est bien effectuer";
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        count++;
        welcomeText.setText(text);
    }
}