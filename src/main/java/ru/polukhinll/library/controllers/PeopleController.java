package ru.polukhinll.library.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeopleController {

    @GetMapping("/people")
    public String index() {
        System.out.println("index method");
        return "people/index";
    }
}
