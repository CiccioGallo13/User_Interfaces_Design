package com.unical.sium.uidbrowser.controller;
import com.unical.sium.uidbrowser.HelloApplication;
import com.unical.sium.uidbrowser.model.TabManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class TextEditorController
{

        @FXML
        private TabPane tabPane;

        @FXML
        void about(ActionEvent event) {
            Dialog<DialogPane> pane = new Dialog<>();
            DialogPane aboutPane = new DialogPane();
            aboutPane.setContentText("Developed for User Interfaces Design!");
            aboutPane.getButtonTypes().add(ButtonType.OK);
            pane.setTitle("About");
            pane.setDialogPane(aboutPane);
            pane.showAndWait();
        }

        @FXML
        void exit(ActionEvent event) {
            Stage myStage= TabManager.getInstance().getMyStage();
                    myStage.fireEvent(
                    new WindowEvent(
                            myStage, WindowEvent.WINDOW_CLOSE_REQUEST
                    ));
        }

        @FXML
        void newTab() throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("web-tab.fxml"));
            int index = tabPane.getTabs().size();
            Tab myTab = new Tab("Empty",fxmlLoader.load());
            myTab.setOnCloseRequest(event -> {
                if(tabPane.getTabs().size()<=2)
                    event.consume();
            });
            tabPane.getTabs().add(index-1, myTab);
            tabPane.getSelectionModel().select(index-1);
        }

        @FXML
        void initialize(){

        }
    }

