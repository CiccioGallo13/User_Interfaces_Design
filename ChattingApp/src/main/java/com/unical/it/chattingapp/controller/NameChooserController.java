package com.unical.it.chattingapp.controller;

import com.unical.it.chattingapp.model.Contacts;
import com.unical.it.chattingapp.model.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class NameChooserController {

    @FXML
    private TextField contactName;

    @FXML
    void closeStage(ActionEvent event) {
        SceneHandler.getInstance().closeChooserStage();
    }

    @FXML
    void saveContact(ActionEvent event) {

        Contacts.getInstance().add(contactName.getText());
        SceneHandler.getInstance().refreshContacts();
        SceneHandler.getInstance().closeChooserStage();
    }

}
