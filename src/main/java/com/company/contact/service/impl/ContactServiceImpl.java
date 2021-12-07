package com.company.contact.service.impl;

import com.company.contact.model.Contact;
import com.company.contact.model.Phone;
import com.company.contact.repository.ContactRepository;
import com.company.contact.repository.PhoneRepository;
import com.company.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    @Autowired
    private final ContactRepository contactRepository;

    @Autowired
    private final PhoneRepository phoneRepository;

    @Override
    public void create(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public ResponseEntity<Contact> read(int id) {
        Contact fromDb = contactRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found such a data with this parameters"));
        return new ResponseEntity<>(fromDb, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Contact>> readAll() {
        return new ResponseEntity<>(contactRepository.findAll(), HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<Contact> update(int id, Contact contact) {
        Contact fromDb = contactRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found such a data with this parameters"));

        List<Phone> phoneList = fromDb.getPhones();
        phoneList.forEach(item -> {
            phoneRepository.deleteById(item.getId());
        });
        fromDb.getPhones().clear();

        phoneList.addAll(contact.getPhones());
        fromDb.setFirstName(contact.getFirstName());
        fromDb.setLastName(contact.getLastName());
        return new ResponseEntity<>(contactRepository.save(fromDb), HttpStatus.OK);
    }

    @Override
    public void delete(int id) {
        contactRepository.deleteById(id);
    }

}
