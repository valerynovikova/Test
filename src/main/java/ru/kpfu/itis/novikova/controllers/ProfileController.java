package ru.kpfu.itis.novikova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.novikova.model.Account;
import ru.kpfu.itis.novikova.service.AccountService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final AccountService accountService;





}

