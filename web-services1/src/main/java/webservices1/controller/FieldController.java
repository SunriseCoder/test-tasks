package webservices1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webservices1.entities.Field;
import webservices1.exceptions.RequestException;
import webservices1.services.FieldService;

@RestController
@RequestMapping("/api/field")
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @PutMapping("")
    public Map<String, String> addField(@RequestBody Map<String, String> requestBody) {
        Map<String, String> response = fieldService.add(requestBody);
        return response;
    }

    @PostMapping("{id}")
    public void editField(@PathVariable("id") Long id, @RequestBody Map<String, String> requestBody) throws RequestException {
        fieldService.update(id, requestBody);
    }

    @DeleteMapping("{id}")
    public void deleteField(@PathVariable("id") Long id) throws RequestException {
        fieldService.delete(id);
    }

    @GetMapping("")
    public List<Map<String, String>> getAllFields() throws RequestException {
        List<Map<String, String>> response = new ArrayList<>();
        List<Field> fields = fieldService.getAll();
        for (Field field : fields) {
            Map<String, String> fieldMap = fieldToMap(field);
            response.add(fieldMap);
        }
        return response;
    }

    @GetMapping("{id}")
    public Map<String, String> getField(@PathVariable("id") Long id) throws RequestException {
        Field field = fieldService.get(id);
        if (field == null) {
            throw new RequestException("field.does.not.exist", 5, "Field does not exist");
        }
        Map<String, String> response = fieldToMap(field);
        return response;
    }

    private Map<String, String> fieldToMap(Field field) throws RequestException {
        Map<String, String> fieldMap = new HashMap<>();

        fieldMap.put("FieldId", field.getId().toString());
        fieldMap.put("Lat", field.getLat());
        fieldMap.put("Lon", field.getLon());
        fieldMap.put("FieldName", field.getName());
        fieldMap.put("AccountName", field.getAccount().getName());
        fieldMap.put("AccountEmail", field.getAccount().getEmail());

        return fieldMap;
    }
}
