package ru.kpfu.itis.novikova.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import ru.kpfu.itis.novikova.service.AccountService;

import ru.kpfu.itis.novikova.service.LectureService;


@Controller
public class LectureController {

    private final LectureService lectureService;
    private final AccountService accountService;

    @Autowired
    public LectureController(LectureService lectureService, AccountService accountService) {
        this.lectureService = lectureService;
        this.accountService = accountService;
    }




}
