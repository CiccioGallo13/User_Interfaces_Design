package com.unical.sium.uidbrowser.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebTabController {

    private WebEngine engine;

    @FXML
    private TextField searchBar;

    @FXML
    private WebView webView;

    @FXML
    void search(ActionEvent event) {
        engine.load("https://www.google.it/search?q="+ searchBar.getText().replace(" ", "+"));
    }

    @FXML
    void initialize(){
        engine = webView.getEngine();
        engine.load("https://www.google.it/");

    }

}
