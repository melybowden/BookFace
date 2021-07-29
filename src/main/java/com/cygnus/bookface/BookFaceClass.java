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

    private String imageURL;
    private String title;
    private String author;
    private Long year;
    private Long isbn;

    public BookFaceClass() {
        this.imageURL = null;
        this.title = null;
        this.author = null;
        this.year = null;
        this.isbn = null;
    }

    public BookFaceClass(String imageURL, String title, String author, Long year, Long isbn) {
        this.imageURL = imageURL;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    public BookFaceClass(BookFaceClass other, Long id) {
        this.imageURL = other.getImageURL();
        this.title = other.getTitle();
        this.author = other.getAuthor();
        this.year = other.getYear();
        this.isbn = other.getIsbn();
        this.id = id;
    }

    public Long getID() {
        return this.id;
    }

    
    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public Long getYear() {
        return this.year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getIsbn() {
        return this.isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}
