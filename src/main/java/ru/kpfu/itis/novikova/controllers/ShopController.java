package ru.kpfu.itis.novikova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/orders")
public class ShopController {

    @GetMapping
    public String getOrdersPage() {
        return "orders";
    }

}

