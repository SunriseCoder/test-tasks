package webservices1.services;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webservices1.entities.Account;
import webservices1.entities.Field;
import webservices1.repositories.AccountRepository;
import webservices1.repositories.FieldRepository;

@Component
public class FieldService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private FieldRepository fieldRepository;

    public Account getByAccountName(String accountName) {
        Account account = accountRepository.findOneByName(accountName);
        return account;
    }

    @Transactional
    public Map<String, String> add(Map<String, String> requestBody) {
        Account account = accountRepository.findOneByName(requestBody.get("AccountName"));
        if (account == null) {
            account = new Account();
            account.setName(requestBody.get("AccountName"));
            account.setEmail(requestBody.get("AccountEmail"));
            account = accountRepository.save(account);
        }

        Field field = new Field();
        field.setName(requestBody.get("FieldName"));
        field.setLat(requestBody.get("Lat"));
        field.setLon(requestBody.get("Lon"));
        field.setAccount(account);
        fieldRepository.save(field);

        Map<String, String> response = new HashMap<>();
        response.put("FieldId", String.valueOf(field.getId()));
        response.put("AccountId", String.valueOf(account.getId()));
        return response;
    }
}
