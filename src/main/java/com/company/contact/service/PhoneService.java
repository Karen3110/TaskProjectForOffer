package com.company.contact.service;

import com.company.contact.model.Contact;
import com.company.contact.model.Phone;
import org.springframework.http.ResponseEntity;

public interface PhoneService {

    ResponseEntity<Contact> create(int id, Phone phone);

    ResponseEntity<Phone> read(int id);

    ResponseEntity<Phone> update(int id, Phone phone);

    void delete(int id);

}
