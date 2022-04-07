package com.unical.sium.bookmanager.model;

import com.unical.sium.bookmanager.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler {
    private static SceneHandler instance = new SceneHandler();
    private Stage stage;
    private SceneHandler(){
    }

    public void initialize(Stage stage){
        this.stage=stage;
    }
    public static SceneHandler getInstance(){
        return  instance;
    }

    public void bookShelfScene(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bookShelf-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
        }
        stage.setMinHeight(400);
        stage.setMinWidth(600);
        stage.setHeight(400);
        stage.setWidth(600);
        stage.setResizable(true);
        stage.setTitle("Books");
        stage.setScene(scene);
        stage.show();
    }

    public void bookAdderScene(){
        Stage bookStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bookAdder-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 300, 330);
        } catch (IOException e) {
        }
        bookStage.setResizable(false);
        bookStage.setTitle("Books");
        bookStage.setScene(scene);
        bookStage.show();
    }

    public void loginScene(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 400, 200);
        } catch (IOException e) {
        }
        stage.setMinHeight(200);
        stage.setMinWidth(400);
        stage.setHeight(200);
        stage.setWidth(400);
        stage.setResizable(false);
        stage.setTitle("Books");
        stage.setScene(scene);
        stage.show();
    }
}
