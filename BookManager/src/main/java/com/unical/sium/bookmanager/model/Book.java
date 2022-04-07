package com.unical.sium.bookmanager.model;

import javafx.beans.InvalidationListener;
import javafx.collections.ArrayChangeListener;
import javafx.collections.ObservableArray;

public class Book {
    private String isbn, title, author, publisher;
    private Integer year;

    public Book(String isbn, String title, String author, String publisher, Integer year) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }


}
