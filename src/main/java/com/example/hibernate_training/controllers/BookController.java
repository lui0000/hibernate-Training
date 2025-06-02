package com.example.hibernate_training.controllers;

import com.eliza.jdbcTemplate.dao.BookDao;
import com.eliza.jdbcTemplate.models.Book;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;


    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping
    public List<Book> index() {
        return bookDao.index();
    }

    @GetMapping("/{id}")
    public Book show(@PathVariable("id") int id) {
        return bookDao.show(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }

        }
        bookDao.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") int id ,@RequestBody @Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error: errors) {
                errorMsg.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }

        }
        bookDao.update(id, book);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        bookDao.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
