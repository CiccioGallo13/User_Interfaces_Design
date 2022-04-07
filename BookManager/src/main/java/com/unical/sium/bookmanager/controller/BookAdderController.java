package com.unical.sium.bookmanager.controller;

import com.unical.sium.bookmanager.model.Book;
import com.unical.sium.bookmanager.model.Books;
import com.unical.sium.bookmanager.model.SceneHandler1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BookAdderController {

    @FXML
    private TextField authorField;

    @FXML
    private TextField isbnField;

    @FXML
    private TextField publisherField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField yearField;

    @FXML
    void addBook(ActionEvent event) {

        Books.getInstance().addBook(new Book(isbnField.getText(), titleField.getText(), authorField.getText(), publisherField.getText(), Integer.parseInt(yearField.getText())));
        SceneHandler1.getInstance().closeBookStage();
    }

}
