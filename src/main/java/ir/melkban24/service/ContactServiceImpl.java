package ir.melkban24.service;

import ir.melkban24.model.Contact;
import ir.melkban24.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    public Contact findByContactId(Long id) {
        return this.contactRepository.findOne(id);
    }

    @Override
    @Transactional
    public void save(Contact contact) {
        this.contactRepository.save(contact);
    }
}
