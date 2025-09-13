package ru.polukhinll.library.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    @NotEmpty(message = "title should be not empty")
    @Size(min = 2, max = 100, message = "size of title should be between 2 of 100 characters")
    private String title;

    @NotEmpty(message = "author should be not empty")
    @Size(min = 2, max = 100, message = "size of author should be between 2 of 100 characters")
    private String author;

    @Min(value = 1000, message = "year_of_publication should be more than 1000")
    @Max(value = 2025, message = "year_of_publication should be less than 2026")
    private int year_of_publication;

    public Book() {}

    public Book(String title, String author, int year_of_publication) {
        this.title = title;
        this.author = author;
        this.year_of_publication = year_of_publication;
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

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }
}
