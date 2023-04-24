package ru.kpfu.itis.novikova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String getRootPage() {

        return "home";
    }
}
