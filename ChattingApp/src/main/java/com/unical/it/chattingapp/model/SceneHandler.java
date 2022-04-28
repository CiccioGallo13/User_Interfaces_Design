package com.unical.it.chattingapp.model;

import com.unical.it.chattingapp.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class SceneHandler {
    private static SceneHandler instance = new SceneHandler();

    private SceneHandler(){}

    public static SceneHandler getInstance()
    {
        return instance;
    }

    private Stage nameChooser;
    private VBox contacts_ref;
    private TextArea textArea_ref;
    public void nameChooserStageOpen() throws IOException {
        nameChooser = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("name-chooser.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 110);
        nameChooser.setScene(scene);
        nameChooser.show();
    }

    public void closeChooserStage(){
        nameChooser.close();
    }

    public void refreshContacts(){
        contacts_ref.getChildren().setAll(Contacts.getInstance().getContacts());
    }

    public void setReferences(TextArea txt, VBox contacts){
        textArea_ref = txt;
        contacts_ref = contacts;
    }
    public void cleanBlackBoard(){
        textArea_ref.clear();
    }
}

