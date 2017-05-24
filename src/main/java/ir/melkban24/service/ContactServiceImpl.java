package ir.melkban24.service;

import ir.melkban24.model.Contact;
import ir.melkban24.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mehdi on 5/24/17.
 */
@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return this.contactRepository.findAll();
    }
}
