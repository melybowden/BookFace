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

    public BookFaceClass() {
        this.title = null;
        this.author = null;
        this.isbn = null;
    }

    public BookFaceClass(String title, String author, Long isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public BookFaceClass(BookFaceClass other, Long id) {
        this.title = other.getTitle();
        this.author = other.getAuthor();
        this.isbn = other.geIsbn();
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

    public Long geIsbn() {
        return this.isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}
