package com.company.contact.service.impl;

import com.company.contact.model.Contact;
import com.company.contact.model.Phone;
import com.company.contact.repository.ContactRepository;
import com.company.contact.repository.PhoneRepository;
import com.company.contact.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private final PhoneRepository phoneRepository;
    @Autowired
    private final ContactRepository contactRepository;

    @Override
    @Transactional
    public ResponseEntity<Contact> create(int id, Phone phone) {
        Contact fromDb = contactRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found such a data with this parameters"));
        fromDb.getPhones().add(phone);

        return new ResponseEntity<>(fromDb, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Phone> read(int id) {
        Phone phone = phoneRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found such a data with this parameters"));
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Phone> update(int id, Phone phone) {

        return null;
    }

    @Transactional
    @Override
    public void delete(int id) {
        phoneRepository.deletePhoneById(id);
    }
}
