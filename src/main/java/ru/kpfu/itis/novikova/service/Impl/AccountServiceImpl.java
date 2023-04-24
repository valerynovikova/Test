package ru.kpfu.itis.novikova.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.novikova.dto.AccountDto;
import ru.kpfu.itis.novikova.dto.SignUpForm;
import ru.kpfu.itis.novikova.model.Account;
import ru.kpfu.itis.novikova.repositories.AccountRepository;
import ru.kpfu.itis.novikova.service.AccountService;


import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;


    @Value("${server.port}")
    String accountDto;


    @Override
    public void signUp(SignUpForm form) {

    }

    @Override
    public void updateState(String confirmCode) {
        Account account = accountRepository.findAllByConfirmCode(confirmCode);
        account.setState(Account.State.CONFIRMED);
        accountRepository.save(account);
    }

    @Override
    public void update(AccountDto accountDto, String email) {
        accountRepository.updateAccount(accountDto.getFirstName(), accountDto.getLastName(), passwordEncoder.encode(accountDto.getPassword()), email);
    }

    @Override
    public Optional<Account> getAccountByEmail(String email) {
        return accountRepository.getAccountByEmail(email);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> allUsers = accountRepository.findAll();

        return allUsers.stream()
                .map(AccountDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> getAccountsByEmailLike(String email) {
        List<Account> allUsers;

        if (email.isEmpty() || email == null) {
            allUsers = accountRepository.findAll();
        } else {
            allUsers = accountRepository.getAllByEmailContains(email);
        }

        return allUsers.stream()
                .map(AccountDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountById(Long userId) {
        return AccountDto.fromModel(accountRepository.getById(userId));
    }


    @Override
    public Account getRawAccountByEmail(String email) {
        Optional<Account> user = accountRepository.getAccountByEmail(email);

        return user.get();
    }

}
