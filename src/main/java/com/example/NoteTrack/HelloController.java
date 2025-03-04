package com.example.NoteTrack;

import com.example.NoteTrack.entities.Role;
import com.example.NoteTrack.entities.User;

import com.example.NoteTrack.services.UserService;
import com.example.NoteTrack.utils.enumarations.RoleEnum;
import com.example.NoteTrack.utils.interfaces.servicesInterface.IRoleService;
import com.example.NoteTrack.utils.interfaces.servicesInterface.gestionAuthentification.IUserService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField inputUsername;
    @FXML
    private TextField inputPassword;

    private int count = 0;

    // Empty constructor required for JavaFX
    public HelloController() {
    }

    // Called after FXML fields are injected
    @FXML
    public void initialize() {
        String text;
        try {
            User userAuth = UserService.getUtilisateurAuthentifier();
            text = userAuth != null ? "Utilisateur " + userAuth.getUsername() + " authentifié avec pour role: "+userAuth.getRoles().get(0).getRole(): "Problème d'authentification";
            count++;
        } catch (SQLException e) {
            text = "Erreur: " + e.getMessage();
        }
        welcomeText.setText(text );
    }

    @FXML
    protected void onHelloButtonClick() {
        String text;
        try {
           User user = testLogin(new UserService(), inputUsername.getText(), inputPassword.getText());
            text = user != null ? "Utilisateur " + user.getUsername() + " authentifié" : "Problème d'authentification";
            count++;
        } catch (SQLException e) {
            text = "Erreur: " + e.getMessage();
        }
        welcomeText.setText(text + " (Clics: " + count + ")");
    }

    private User testLogin(IUserService userService, String username, String password) {
        return userService.login(username, password);
    }

    @FXML
    protected void HidePassword() {
        // Consider using PasswordField instead of this approach
        String password = inputPassword.getText();
//        if (!password.isEmpty()) {
//            inputPassword.setText("*".repeat(password.length()));
//        }
    }

    private void initialiseRole(IRoleService roleService) throws SQLException {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            Role role = new Role(roleEnum.getDescription(), roleEnum);
            roleService.ajouterRole(role);
        }
    }

    private boolean createAdministrateurSysteme(IUserService userService) throws SQLException {
        User user = new User("NTPbreak", "password", "patricknegoue197@gmail.com", "Negoue Tchinda", "Patrick");
        return userService.registerWithRole(user, RoleEnum.ADMINISTRATEUR);
    }
}