package unical.sium.imageviewer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.EventListener;
import java.util.Optional;

public class HelloController {

    @FXML
    private ImageView displayer;

    @FXML
    private Button loaderButton;

    @FXML
    private VBox vboxPanel;

    @FXML
    void OpenExplorer(ActionEvent event) {
        ImageChooser.add();
        TextInputDialog name = new TextInputDialog();
        name.setTitle("Digita il nome dell'immagine");
        Optional<String> imageName = name.showAndWait();
        if (imageName.isPresent()) {
            //imgpanel.setSpacing(40);
            //imgpanel.setAlignment(Pos.CENTER_LEFT);
            ImageView pic = new ImageView(ImageChooser.getImage());
            pic.setFitHeight(40);
            pic.setFitWidth(40);
            ImgPanel imgpanel = new ImgPanel(pic, new Label(imageName.get()), displayer);
            //imgpanel.setOnMouseClicked(e -> {displayer.setImage(ImageChooser.getImage(vboxPanel.getChildren().size()));});
            vboxPanel.setSpacing(10);
            vboxPanel.getChildren().add(imgpanel);
        }
    }
}
