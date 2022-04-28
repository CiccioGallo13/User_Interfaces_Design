package com.unical.sium.uidtexteditor.module;

import javafx.stage.FileChooser;

import java.io.File;
import java.util.Hashtable;

public class FileTab{
    private static FileTab instance = new FileTab();

    private Hashtable<String, String> filePaths = new Hashtable<>();
    private FileTab(){

    }

    public static FileTab getInstance(){
        return instance;
    }

    public File openFile(){
        FileChooser fChooser = new FileChooser();
        File fileOpened = fChooser.showOpenDialog(null);
        filePaths.put(fileOpened.getName(), fileOpened.getAbsolutePath());
        return fileOpened;
    }

    public String getPath(String _name){
        return filePaths.get(_name);
    }
}
