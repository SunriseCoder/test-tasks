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
import webservices1.services.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("{id}")
    public Map<String, Object> getField(@PathVariable("id") Long id) {
        Account account = accountService.get(id);
        Map<String, Object> response = accountToMap(account);
        return response;
    }

    private Map<String, Object> accountToMap(Account account) {
        Map<String, Object> fieldMap = new HashMap<>();

        fieldMap.put("AccountId", account.getId().toString());
        fieldMap.put("AccountName", account.getName());
        fieldMap.put("AccountEmail", account.getEmail());

        List<String> fields = new ArrayList<>();
        for (Field field : account.getFields()) {
            fields.add(field.getId().toString());
        }
        fieldMap.put("Fields", fields);

        return fieldMap;
    }
}
