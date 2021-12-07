package com.company.contact.service;

import com.company.contact.model.Contact;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {

    void create(Contact contact);

    ResponseEntity<Contact> read(int id);

    ResponseEntity<Contact> update(int id, Contact contact);

    void delete(int id);

    ResponseEntity<List<Contact>> readAll();

}
