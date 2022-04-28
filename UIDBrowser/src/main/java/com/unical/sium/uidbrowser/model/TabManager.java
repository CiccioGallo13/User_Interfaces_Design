package com.unical.sium.uidbrowser.model;

import com.unical.sium.uidbrowser.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

import java.io.IOException;

public class TabManager {
    private static TabManager instance = new TabManager();
    private TabManager(){}
    private Stage myStage;
    public static TabManager getInstance(){
        return instance;
    }

    public void setStage(Stage _stage){
        myStage = _stage;
    }
    public Stage getMyStage(){
        return myStage;
    }
}
