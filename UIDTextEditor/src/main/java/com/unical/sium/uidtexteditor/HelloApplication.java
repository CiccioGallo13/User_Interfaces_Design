package com.unical.sium.uidtexteditor;

import com.unical.sium.uidtexteditor.controller.StageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("txt-editor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("UID Text Editor");
        stage.setScene(scene);
        StageController.getInstance().setMyStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}