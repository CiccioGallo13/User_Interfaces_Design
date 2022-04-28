package com.unical.sium.uidtexteditor.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class StageController {

    Stage myStage = null;

    private static StageController instance = new StageController();

    private StageController(){}

    public static StageController getInstance(){
        return instance;
    }
    private int toSave = 0;

    public void saved(){toSave-=1;}
    public void notSaved(){toSave+=1;}

    public void setMyStage(Stage tmp){
        myStage = tmp;
        myStage.setOnCloseRequest(event -> {if(toSave!=0)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Wait the file is not saved!");
            alert.setTitle("!!!WAIT!!!");
            Optional<ButtonType> clicked = alert.showAndWait();
            if(clicked.get() == ButtonType.CANCEL)
            {
                event.consume();
            }
        }
        });
    }

    public void tryClose(){
        /*if(toSave!=0)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Wait the file is not saved!");
            alert.setTitle("!!!WAIT!!!");
            Optional<ButtonType> clicked = alert.showAndWait();
            if(clicked.get() == ButtonType.OK)
            {
                myStage.close();
            }
        }
        else {

            myStage.close();
        }*/
        myStage.fireEvent(
            new WindowEvent(
                myStage, WindowEvent.WINDOW_CLOSE_REQUEST
            )
        );
    }
}
