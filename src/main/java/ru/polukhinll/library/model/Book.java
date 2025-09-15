package ru.polukhinll.library.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int book_id;

    @NotEmpty(message = "title should be not empty")
    @Size(min = 2, max = 100, message = "size of title should be between 2 of 100 characters")
    private String title;

    @NotEmpty(message = "author should be not empty")
    @Size(min = 2, max = 100, message = "size of author should be between 2 of 100 characters")
    private String author;

    @Min(value = 1000, message = "year_of_publication should be more than 1000")
    @Max(value = 2025, message = "year_of_publication should be less than 2026")
    private int yearOfPublication;

    public Book() {}

    public Book(int book_id, String title, String author, int yearOfPublication) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
   }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
