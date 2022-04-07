package com.unical.sium.bookmanager;

import com.unical.sium.bookmanager.model.SceneHandler;
import com.unical.sium.bookmanager.model.SceneHandler1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneHandler1.getInstance().initialize(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}