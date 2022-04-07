package unical.sium.imageviewer;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.*;

public class ImageChooser {
    private static List<Image> images = new ArrayList<Image>();
    public static void add(){
        FileChooser filechooser= new FileChooser();
        filechooser.setTitle("Seleziona immagine");
        filechooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("JPG / PNG", List.of(".jpg", ".png")));
        File image = filechooser.showOpenDialog(null);
        if(image!= null) {
            {
                images.add(new Image(image.getAbsolutePath()));
                System.out.println("Immagine presa!!");
            }
        }
    }
    public static Image getImage(){
        return images.get(images.size()-1);
    }
    public static Image getImage(int index){
        return images.get(index);
    }

}
