package com.example.NoteTrack;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    private int count = 0;

    @FXML
    protected void onHelloButtonClick() {
        count++;
        String text = "Vous avez cliquer "+count+" fois sur le boutton";
        welcomeText.setText(text);
    }
}