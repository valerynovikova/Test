package ru.kpfu.itis.novikova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.novikova.service.AccountService;
import ru.kpfu.itis.novikova.service.ArticleService;


@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final AccountService accountService;

    @Autowired
    public ArticleController(ArticleService articleService, AccountService accountService) {
        this.articleService = articleService;
        this.accountService = accountService;
    }
    @GetMapping("/timeline")
    public String getTimeLinePage() {

        return "timeline";
    }
}
