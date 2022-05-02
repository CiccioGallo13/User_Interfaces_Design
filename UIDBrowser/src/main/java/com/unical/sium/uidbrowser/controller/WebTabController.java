package com.unical.sium.uidbrowser.controller;

import com.unical.sium.uidbrowser.model.TabManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebTabController {

    private WebEngine engine;

    @FXML
    private TextField searchBar;

    @FXML
    private WebView webView;

    @FXML
    void search() {
        if(searchBar.getText().contains(" ") || !searchBar.getText().contains("//"))
            engine.load("https://www.google.it/search?q="+ searchBar.getText().replace(" ", "+"));
        else
            engine.load(searchBar.getText());

        TabManager.getInstance().getTabpane().getSelectionModel().getSelectedItem().setText(engine.getLocation());
    }

    @FXML
    void initialize(){
        engine = webView.getEngine();
        engine.load("https://www.google.it/");

        searchBar.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER)
                search();
            else
                event.consume();
        });
        engine.setOnStatusChanged(event -> {TabManager.getInstance().getTabpane().getSelectionModel().getSelectedItem().setText(engine.getLocation());});

    }

}
