package com.unical.sium.bookmanager.model;

import javafx.beans.InvalidationListener;
import javafx.collections.*;

import java.util.*;

public class Books {
    private static Books instance = new Books();

    private Books(){

    }

    public static Books getInstance(){
        return instance;
    }

    private ObservableList<Book> books = FXCollections.observableArrayList();

    public ObservableList<Book> getBooks(){
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

}
