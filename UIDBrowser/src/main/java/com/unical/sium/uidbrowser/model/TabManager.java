package com.unical.sium.uidbrowser.model;

import com.unical.sium.uidbrowser.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TabManager {
    private static TabManager instance = new TabManager();
    private TabManager(){}
    private Stage myStage;
    private TabPane tabpane;

    public static TabManager getInstance(){
        return instance;
    }

    public void setStage(Stage _stage){
        myStage = _stage;
    }

    public void setTabpane(TabPane tabpane) {
        this.tabpane = tabpane;
    }

    public Stage getMyStage(){
        return myStage;
    }

    public TabPane getTabpane(){
        return tabpane;
    }
}
