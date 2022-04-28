package com.unical.it.chattingapp.controller;

import com.unical.it.chattingapp.model.Contacts;
import com.unical.it.chattingapp.model.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomeController {

    @FXML
    private VBox contacts;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    void addContact(ActionEvent event) throws IOException {
        SceneHandler.getInstance().nameChooserStageOpen();
    }

    @FXML
    void send(ActionEvent event) {
        if(Contacts.getInstance().getContacts().size()>0) {
            textArea.appendText(textField.getText() + "\n");
            textField.clear();
        }
    }

    @FXML
    void initialize(){
        SceneHandler.getInstance().setReferences(textArea, contacts);
        contacts.setSpacing(15);
    }
}

