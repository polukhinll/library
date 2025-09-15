package ru.polukhinll.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.polukhinll.library.dao.BookDAO;
import ru.polukhinll.library.model.Book;
import ru.polukhinll.library.model.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {

    private BookDAO bookDAO;

    @Autowired
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/new")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "books/new";

        bookDAO.create(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        model.addAttribute("people", bookDAO.getPeople());
        model.addAttribute("takedBooks", bookDAO.getTakedBooks(id));
        model.addAttribute("person", new Person());
        return "books/show";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "reditect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}/edit")
    public String edit(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) return "books/edit";

        bookDAO.edit(id, book);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/appoint")
    public String appointBook(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        bookDAO.appointBook(id, person);
        return "redirect:/books";
    }
}
