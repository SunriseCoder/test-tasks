package webservices1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webservices1.entities.Account;
import webservices1.entities.Field;
import webservices1.exceptions.RequestException;
import webservices1.services.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public List<Map<String, Object>> getAll() {
        List<Account> accounts = accountService.getAll();

        List<Map<String, Object>> response = new ArrayList<>();
        for (Account account : accounts) {
            Map<String, Object> accountMap = accountToMap(account);
            response.add(accountMap);
        }

        return response;
    }

    @GetMapping("{id}")
    public Map<String, Object> get(@PathVariable("id") Long id) throws RequestException {
        Account account = accountService.get(id);
        if (account == null) {
            throw new RequestException("account.not.found", 6, "Account not found");
        }
        Map<String, Object> response = accountToMap(account);
        return response;
    }

    private Map<String, Object> accountToMap(Account account) {
        Map<String, Object> accountMap = new HashMap<>();

        accountMap.put("AccountId", account.getId().toString());
        accountMap.put("AccountName", account.getName());
        accountMap.put("AccountEmail", account.getEmail());

        List<String> fields = new ArrayList<>();
        for (Field field : account.getFields()) {
            fields.add(field.getId().toString());
        }
        accountMap.put("Fields", fields);

        return accountMap;
    }
}
