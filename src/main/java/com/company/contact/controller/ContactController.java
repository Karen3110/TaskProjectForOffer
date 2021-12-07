package com.company.contact.controller;

import com.company.contact.model.Contact;
import com.company.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add")
    void create(@RequestBody Contact contact) {
        contactService.create(contact);
    }

    @GetMapping("/{id}")
    ResponseEntity<Contact> read(@PathVariable int id) {
        return contactService.read(id);
    }

    @GetMapping
    ResponseEntity<List<Contact>> readAll() {
        return contactService.readAll();
    }

    @PutMapping("/{id}")
    ResponseEntity<Contact> update(@PathVariable int id, @RequestBody Contact contact) {
        return contactService.update(id, contact);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        contactService.delete(id);
    }
}
