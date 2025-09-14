package ru.polukhinll.library.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int person_id;

    @NotEmpty(message = "fio should be not empty")
    @Size(min = 3, max = 150, message = "size of fio should be between 3 of 150")
    private String fio;

    @Max(value = 2025, message = "year_of_birth should be less than 2026")
    private int yearOfBirth;

    public Person() {}

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public Person(int person_id, String fio, int yearOfBirth) {
        this.person_id = person_id;
        this.fio = fio;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
