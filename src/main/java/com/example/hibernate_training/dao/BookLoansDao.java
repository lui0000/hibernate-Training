package com.example.hibernate_training.dao;

import com.eliza.jdbcTemplate.models.BookAndReader;
import com.eliza.jdbcTemplate.models.BookLoans;
import com.eliza.jdbcTemplate.models.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookLoansDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookLoansDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookLoans> index() {
        return jdbcTemplate.query("SELECT * FROM c", new BeanPropertyRowMapper<>(BookLoans.class));
    }

    public BookLoans show(int id) {
        return jdbcTemplate.query("SELECT * FROM book_loans WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(BookLoans.class)).
                stream().findAny().orElse(null);
    }
    public void create(BookLoans bookLoans) {
        jdbcTemplate.update("INSERT INTO book_loans(book_id, reader_id, loan_date, return_date, actual_return_date) VALUES(?, ?, ?, ?, ?)", bookLoans.getBook_id(), bookLoans.getReader_id(), bookLoans.getLoanDate(), bookLoans.getReturnDate(), bookLoans.getActualReturnDate());
    }

    public void update(int id, BookLoans bookLoans) {
        jdbcTemplate.update("UPDATE book_loans SET book_id=?, reader_id=?, loanDate=?, returnDate()=?, actualReturnDate=? WHERE id=?",  bookLoans.getBook_id(), bookLoans.getReader_id(), bookLoans.getLoanDate(), bookLoans.getReturnDate(), bookLoans.getActualReturnDate(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book_loans WHERE id=?", id);
    }

    public List<BookAndReader> getRelatedInformationAboutAllBooksAndReaders() {
        return jdbcTemplate.query("SELECT r.name, r.phone, b.title, b.author, b.isbn, b.status FROM reader r\n" +
                "JOIN book_loans bl ON r.id=bl.reader_id JOIN book b ON bl.book_id=b.id;", new BeanPropertyRowMapper<>(BookAndReader.class));
    }


    public List<Reader> getReaderByBook(int id) {
        return jdbcTemplate.query("select r.name, r.phone FROM reader r\n" +
                "JOIN book_loans bl ON r.id=bl.reader_id WHERE bl.book_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Reader.class));
    }

}
