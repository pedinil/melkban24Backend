package ir.melkban24.service;

import ir.melkban24.model.Contact;

import java.util.List;

/**
 * Created by mehdi on 5/24/17.
 */

public interface ContactService {
    List<Contact> findAll();
}
