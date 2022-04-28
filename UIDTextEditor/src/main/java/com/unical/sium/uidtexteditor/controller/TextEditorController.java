package com.unical.sium.uidtexteditor.controller;

import com.unical.sium.uidtexteditor.module.FileTab;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class TextEditorController {

    @FXML
    private javafx.scene.control.TabPane TabPane;

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
    void createFile(ActionEvent event) {
        newTab("Untitled*");
        StageController.getInstance().notSaved();
    }

    @FXML
    void exit(ActionEvent event) {
        StageController.getInstance().tryClose();
    }

    @FXML
    void openFile(ActionEvent event) throws IOException {
        File myfile = FileTab.getInstance().openFile();
        newTab(myfile.getName());
        for(String line: Files.readAllLines(Path.of(myfile.getAbsolutePath())))
        {
            TextArea tmp = (TextArea)TabPane.getSelectionModel().getSelectedItem().getContent();
            tmp.appendText(line+"\n");
        }
    }

    @FXML
    void saveFile(ActionEvent event) throws IOException {
        String fileName = TabPane.getSelectionModel().getSelectedItem().getText();
        if(fileName.contains("*")){
            String path = FileTab.getInstance().getPath(fileName.replace("*",""));
            if(path==null){
                FileChooser saver = new FileChooser();
                File tmp = saver.showSaveDialog(null);
                FileWriter writer = new FileWriter(tmp);
                TextArea txt = (TextArea)TabPane.getSelectionModel().getSelectedItem().getContent();
                writer.write(txt.getText());
                writer.close();
            }
            else {
                File tmp = new File(path);
                FileWriter writer = new FileWriter(tmp);
                TextArea txt = (TextArea)TabPane.getSelectionModel().getSelectedItem().getContent();
                writer.write(txt.getText());
                writer.close();
            }
            TabPane.getSelectionModel().getSelectedItem().setText(fileName.replace("*", ""));
            StageController.getInstance().saved();
        }
    }

    private void newTab(String name){
        String _name = name;
        Tab myTab = new Tab(_name, new TextArea());
        myTab.getContent().setOnKeyTyped(event -> {
            if(!_name.contains("*"))
                myTab.setText(_name+"*");
            StageController.getInstance().notSaved();
        });
        myTab.setOnCloseRequest(e -> {
            if(myTab.getText().contains("*")) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Wait the file is not saved!");
                alert.setTitle("!!!WAIT!!!");
                Optional<ButtonType> clicked = alert.showAndWait();
                if(clicked.get() == ButtonType.CANCEL)
                {
                    e.consume();
                }
            }});
        TabPane.getTabs().add(myTab);
        TabPane.getSelectionModel().select(TabPane.getTabs().size()-1);
        TabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.ALL_TABS);
    }

    @FXML
    void initialize()
    {
        TabPane.setOnKeyPressed(event -> {
            if(event.isAltDown() && event.getCode().isDigitKey())
            {
                int digitIndex = event.getCode().ordinal()-25;
                if(digitIndex< TabPane.getTabs().size() && digitIndex!=-1)
                    TabPane.getSelectionModel().select(digitIndex);
            }
        });
    }

}
