package com.example.hibernate_training.dao;

import com.example.hibernate_training.models.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReaderDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReaderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Reader> index() {
        return jdbcTemplate.query("SELECT * FROM reader", new BeanPropertyRowMapper<>(Reader.class));
    }

    public Reader show(int id) {
        return jdbcTemplate.query("SELECT * FROM reader WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Reader.class))
                .stream().findAny().orElse(null);
    }

    public void save(Reader reader) {
        jdbcTemplate.update("INSERT INTO reader(name, email, phone) VALUES(?, ?, ?)",reader.getName(), reader.getEmail(), reader.getPhone());
    }
    public void update(int id, Reader reader) {
        jdbcTemplate.update("UPDATE reader SET name=?, email=?, phone=? WHERE id=?",reader.getName(), reader.getEmail(), reader.getPhone(), id);
    }
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM reader WHERE id=?", id);
    }

}
