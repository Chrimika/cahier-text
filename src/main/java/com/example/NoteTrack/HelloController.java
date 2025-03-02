package com.example.NoteTrack;

import com.example.NoteTrack.dao.ConnectionDao;
import com.example.NoteTrack.entities.Filiere;
import com.example.NoteTrack.entities.Role;
import com.example.NoteTrack.entities.User;
import com.example.NoteTrack.services.FiliereService;
import com.example.NoteTrack.services.RoleService;
import com.example.NoteTrack.services.TransactionService;
import com.example.NoteTrack.services.UserService;
import com.example.NoteTrack.utils.config.DatabaseConfig;
import com.example.NoteTrack.utils.enumarations.RoleEnum;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IFiliereService;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IRoleService;
import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.IUserService;
import com.mysql.cj.TransactionEventHandler;
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

    private void initialiseRole() throws SQLException {
        IRoleService roleService = new RoleService();
        RoleEnum[] roles = RoleEnum.values();

        for (int i = 0; i < Arrays.stream(roles).count(); i++) {
            Role role = new Role(roles[i].getDescription(), roles[i]);
            roleService.ajouterRole(role);
        }
    }

    private boolean createAdministrateurSysteme() throws SQLException {
        IUserService userService = new UserService();
        User user = new User("NTPbreak","password","patricknegoue197@gmail.com","Negoue Tchinda","Patrick");
        return userService.registerWithRole(user,RoleEnum.ADMINISTRATEUR);
    }
    @FXML
    protected void onHelloButtonClick() {
        String text = "Vous avez cliquer " + count + " fois sur le boutton";
        try {
            boolean success = TransactionService.getInstance().executeTransaction(connection -> createAdministrateurSysteme());
            text = success ? "L'ajout c'est bien effectuer" : "Il s'ablerait qu'il y'ai une erreur";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        count++;
        welcomeText.setText(text);
    }
}