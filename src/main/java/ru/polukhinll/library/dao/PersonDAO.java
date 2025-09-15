package ru.polukhinll.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.polukhinll.library.model.Book;
import ru.polukhinll.library.model.Person;

import java.util.List;

@Component
public class PersonDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person showPerson(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findFirst().orElse(null);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE person_id=?", id);
    }

    public void add(Person person) {
        jdbcTemplate.update("INSERT INTO Person(fio, yearofbirth) VALUES (?, ?)",
                person.getFio(), person.getYearOfBirth());
    }

    public void edit(int id, Person person) {
        jdbcTemplate.update("UPDATE Person SET fio=?, yearOfBirth=? WHERE person_id=?",
                person.getFio(), person.getYearOfBirth(), id);
    }

    public List<Book> haveBooks(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
}
