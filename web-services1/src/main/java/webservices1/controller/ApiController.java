package webservices1.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webservices1.services.FieldService;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private FieldService accountService;

    @PutMapping("/field")
    public Map<String, String> addField(@RequestBody Map<String, String> requestBody) {
        Map<String, String> response = accountService.add(requestBody);
        return response;
    }
}
