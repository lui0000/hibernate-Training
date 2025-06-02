package com.example.hibernate_training.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(max = 100, message = "Title should not exceed 100 characters")
    @Column(name = "tile")
    private String title;

    @NotEmpty(message = "Title should not be empty")
    @Size(max = 100, message = "Title should not exceed 100 characters")
    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private long isbn;

    @Column(name = "publication_year")
    private LocalDate publicationYear;

    @Pattern(regexp = "available|in_use", message = "Status must be 'available' or 'in_use'")
    @Column(name = "status")
    private String status;

    public Book() {
    }

    public Book(String title, String author, long isbn, LocalDate publicationYear, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
