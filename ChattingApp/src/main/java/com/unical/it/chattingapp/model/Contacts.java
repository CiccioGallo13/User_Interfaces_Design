package com.unical.it.chattingapp.model;

import com.unical.it.chattingapp.controller.HomeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;

public class Contacts{

    private ObservableList<Label> contacts = FXCollections.observableArrayList();

    private static Contacts instance = new Contacts();

    private Contacts(){}

    public static Contacts getInstance(){
        return instance;
    }

    public ObservableList<Label> getContacts(){
        return contacts;
    }

    public void add(String _name)
    {
        Label lab = new Label(_name);
        lab.setOnMouseClicked(event -> {SceneHandler.getInstance().cleanBlackBoard();});
        contacts.add(lab);
    }
}
