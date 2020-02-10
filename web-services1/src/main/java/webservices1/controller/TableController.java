package webservices1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webservices1.entities.Field;
import webservices1.services.FieldService;

@Controller
public class TableController {
    @Autowired
    private FieldService fieldService;

    @GetMapping("/")
    public String fieldsTable(Model model) {
        List<Field> fields = fieldService.getAll();
        model.addAttribute("fields", fields);
        return "fieldsTable";
    }
}
