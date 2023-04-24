package ru.kpfu.itis.novikova.service;

import ru.kpfu.itis.novikova.dto.AccountDto;
import ru.kpfu.itis.novikova.dto.SignUpForm;
import ru.kpfu.itis.novikova.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    void signUp(SignUpForm form);
    void updateState(String confirmCode);
    List<AccountDto> getAllAccounts();
    List<AccountDto> getAccountsByEmailLike(String email);
    AccountDto getAccountById(Long userId);
    Account getRawAccountByEmail(String email);
    Optional<Account> getAccountByEmail(String email);
    void update(AccountDto accountDto, String email);
}
