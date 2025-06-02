package com.example.hibernate_training.models;

public class BookAndReader {
    private String name;
    private Long phone;
    private String title;
    private String author;
    private Long isbn;
    private String status;

    public BookAndReader(String name, Long phone, String title, String author, Long isbn, String status) {
        this.name = name;
        this.phone = phone;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }

    public BookAndReader() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
