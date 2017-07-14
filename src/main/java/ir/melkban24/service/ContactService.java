package ir.melkban24.service;

import ir.melkban24.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by mehdi on 5/24/17.
 */

public interface ContactService {
    List<Contact> findAll();
    Contact findByContactId(Long id);
    void save(Contact contact);
    void delete(Contact contact);
    void update(Contact contact);
    Page<Contact> findAllByAgent_id(Long id, Pageable pageable);
}
