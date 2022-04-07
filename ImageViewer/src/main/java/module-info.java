module unical.sium.imageviewer {
    requires javafx.controls;
    requires javafx.fxml;


    opens unical.sium.imageviewer to javafx.fxml;
    exports unical.sium.imageviewer;
}