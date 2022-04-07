package unical.sium.imageviewer;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.EventListener;

public class ImgPanel extends HBox {

    ImgPanel(ImageView i, Label l, ImageView v){
        this.setSpacing(40);
        this.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().addAll(i, l);
        if(i != null && v!= null)
            this.setOnMouseClicked(e -> {v.setImage(i.getImage());});
    }

}

