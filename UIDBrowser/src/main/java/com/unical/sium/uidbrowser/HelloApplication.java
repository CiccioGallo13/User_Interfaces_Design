package com.unical.sium.uidbrowser;

import com.unical.sium.uidbrowser.model.TabManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("text-editor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("UID Browser");
        stage.setScene(scene);
        TabManager.getInstance().setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
/*
    Dialog<DialogPane> pane = new Dialog<>();
    DialogPane aboutPane = new DialogPane();
        aboutPane.setContentText("Developed for User Interfaces Design!");
                aboutPane.getButtonTypes().add(ButtonType.OK);
                pane.setTitle("About");
                pane.setDialogPane(aboutPane);
                pane.showAndWait(); */