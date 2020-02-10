package webservices1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webservices1.entities.Account;
import webservices1.repositories.AccountRepository;

@Component
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account get(Long id) {
        Account account = accountRepository.getOne(id);
        return account;
    }
}
