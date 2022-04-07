package com.unical.sium.bookmanager.model;

import com.unical.sium.bookmanager.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler1 {
    private static SceneHandler1 instance = new SceneHandler1();
    private Stage stage;
    private Stage loginStage;
    private Stage bookStage;
    private Scene myScene;
    private boolean darkTheme = false;
    private SceneHandler1(){
    }

    public void initialize(Stage stage){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 400, 200);
        } catch (IOException e) {
        }
        stage.setResizable(false);
        stage.setTitle("Books");
        stage.setScene(scene);
        stage.show();

        this.loginStage=stage;
        myScene =scene;
        scene.getStylesheets().add("com/unical/sium/bookmanager/style.css");
        scene.getStylesheets().add("com/unical/sium/bookmanager/lightTheme.css");
    }

    public boolean isDarkTheme(){
        return darkTheme;
    }

    public void switchTheme(){
        darkTheme= !darkTheme;
        if(darkTheme) {
            myScene.getStylesheets().remove("com/unical/sium/bookmanager/lightTheme.css");
            myScene.getStylesheets().add("com/unical/sium/bookmanager/darkTheme.css");
        }
        else {
            myScene.getStylesheets().remove("com/unical/sium/bookmanager/darkTheme.css");
            myScene.getStylesheets().add("com/unical/sium/bookmanager/lightTheme.css");
        }
    }

    public static SceneHandler1 getInstance(){
        return  instance;
    }

    public void bookShelfScene(){
        loginStage.close();
        this.stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bookShelf-view.fxml"));
        try {
            myScene.setRoot(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setWidth(600);
        stage.setHeight(400);
        stage.setMinHeight(400);
        stage.setMinWidth(600);
        stage.setResizable(true);
        stage.setScene(myScene);
        stage.show();

    }

    public void closeBookStage(){
        bookStage.close();
    }


    public void bookAdderScene(){
        bookStage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bookAdder-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 300, 330);
        } catch (IOException e) {
        }
        bookStage.setResizable(false);
        bookStage.setTitle("Books");
        bookStage.setScene(scene);
        scene.getStylesheets().add("com/unical/sium/bookmanager/style.css");
        if(darkTheme)
            scene.getStylesheets().add("com/unical/sium/bookmanager/darkTheme.css");
        else
            scene.getStylesheets().add("com/unical/sium/bookmanager/lightTheme.css");
        bookStage.show();
    }

    public void loginScene(){
        stage.close();
        this.loginStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        try {
            myScene.setRoot(fxmlLoader.load());
        } catch (IOException e) {
        }
        loginStage.setResizable(false);
        loginStage.setScene(myScene);
        myScene.getStylesheets().add("com/unical/sium/bookmanager/style.css");
        loginStage.show();

    }
}
