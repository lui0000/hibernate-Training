package com.example.hibernate_training.controllers;

import com.eliza.jdbcTemplate.dao.ReaderDao;
import com.eliza.jdbcTemplate.models.Reader;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/reader")
@RestController
public class ReaderController {
    private final ReaderDao readerDao;

    @Autowired
    public ReaderController(ReaderDao readerDao) {
        this.readerDao = readerDao;
    }

    @GetMapping
    public List<Reader> index() {
        return new ArrayList<>(readerDao.index());
    }

    @GetMapping("/{id}")
    public Reader show(@PathVariable("id") int id) {
        return readerDao.show(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody @Valid Reader reader, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error: errors) {
                errorMsg.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }

        }
        readerDao.save(reader);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
