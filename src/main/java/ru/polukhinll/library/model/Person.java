package ru.polukhinll.library.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    @NotEmpty(message = "fio should be not empty")
    @Size(min = 3, max = 150, message = "size of fio should be between 3 of 150")
    private String fio;

    @Max(value = 2025, message = "year_of_birth should be less than 2026")
    private int year_of_birth;

    public Person() {}

    public Person(String fio, int year_of_birth) {
        this.fio = fio;
        this.year_of_birth = year_of_birth;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }
}
