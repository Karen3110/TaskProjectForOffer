package com.company.contact.controller;

import com.company.contact.model.Phone;
import com.company.contact.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping("/add/{id}")
    void create(@PathVariable int id, @RequestBody Phone phone) {
        phoneService.create(id, phone);
    }

    @GetMapping("/{id}")
    ResponseEntity<Phone> read(@PathVariable int id) {
        return phoneService.read(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<Phone> update(@PathVariable int id, @RequestBody Phone phone) {
        return null;
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        phoneService.delete(id);
    }

}
