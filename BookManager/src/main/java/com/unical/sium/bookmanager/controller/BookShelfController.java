package com.unical.sium.bookmanager.controller;

import com.unical.sium.bookmanager.model.Book;
import com.unical.sium.bookmanager.model.Books;
import com.unical.sium.bookmanager.model.SceneHandler1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookShelfController
{

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> isbnColumn;

    @FXML
    private TableColumn<Book, String> publisherColumn;

    @FXML
    private TableView<Book> tableView;

    @FXML
    private Button themeButton;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, Integer> yearColumn;

    @FXML
    void addBook(ActionEvent event) {
        SceneHandler1.getInstance().bookAdderScene();
    }

    @FXML
    void doLogout(ActionEvent event) {
        SceneHandler1.getInstance().loginScene();
    }

    @FXML
    void switchTheme(ActionEvent event) {
        SceneHandler1.getInstance().switchTheme();

        if(SceneHandler1.getInstance().isDarkTheme())
            themeButton.setText("Set light theme");
        else
            themeButton.setText("Set dark theme");
    }

    @FXML
    void initialize() {
        tableView.setItems(Books.getInstance().getBooks());
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
    }

}
