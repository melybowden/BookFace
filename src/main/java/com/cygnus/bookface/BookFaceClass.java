package com.cygnus.bookface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookFaceClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String author;
    private Long isbn;
    private String imageURL;

    public BookFaceClass() {
        this.title = null;
        this.author = null;
        this.isbn = null;
        this.imageURL = null;
    }

    public BookFaceClass(String title, String author, Long isbn, String imageURL) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.imageURL = imageURL;
    }

    public BookFaceClass(BookFaceClass other, Long id) {
        this.title = other.getTitle();
        this.author = other.getAuthor();
        this.isbn = other.getIsbn();
        this.imageURL = other.getImageURL();
        this.id = id;
    }

    public Long getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getIsbn() {
        return this.isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
