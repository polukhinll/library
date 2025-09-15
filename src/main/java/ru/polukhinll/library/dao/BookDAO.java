package ru.polukhinll.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.polukhinll.library.model.Book;
import ru.polukhinll.library.model.Person;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO Book (title, author, yearofpublication) VALUES (?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYearOfPublication());

    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", id);
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findFirst().orElse(null);
    }

    public void edit(int id, Book book) {
        jdbcTemplate.update("UPDATE Book SET title=?, author=?, yearofpublication=? WHERE book_id=?",
                book.getTitle(), book.getAuthor(), book.getYearOfPublication(), id);
    }

    public List<Person> getPeople() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> getTakedBooks(int id) {
        return jdbcTemplate.query("SELECT Person.fio FROM Person JOIN Book ON Person.person_id=Book.person_id WHERE book_id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    public void appointBook(int id, Person person) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE book_id=?", person.getPerson_id(), id);
    }

    public Person ownerBook(int id) {
        return jdbcTemplate.query("SELECT fio FROM Person JOIN Book ON Person.person_id=Book.person_id WHERE book_id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findFirst().orElse(null);
    }

    public void freeBook(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=null WHERE book_id=?", id);
    }
}
