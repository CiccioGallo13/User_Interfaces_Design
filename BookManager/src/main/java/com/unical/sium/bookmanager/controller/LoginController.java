package com.unical.sium.bookmanager.controller;

import com.unical.sium.bookmanager.model.SceneHandler;
import com.unical.sium.bookmanager.model.SceneHandler1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private PasswordField passField;

    @FXML
    private TextField usernameField;

    @FXML
    void doLogin(ActionEvent event) {
        SceneHandler1.getInstance().bookShelfScene();
    }

}
