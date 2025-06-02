package com.example.hibernate_training.models;

import java.time.LocalDate;

public class BookLoans {
    private int id;
    private int book_id;
    private int reader_id;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private LocalDate actualReturnDate;

    public BookLoans() {
    }

    public BookLoans(int id, int book_id, int reader_id, LocalDate loanDate, LocalDate returnDate, LocalDate actualReturnDate) {
        this.id = id;
        this.book_id = book_id;
        this.reader_id = reader_id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.actualReturnDate = actualReturnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
}
