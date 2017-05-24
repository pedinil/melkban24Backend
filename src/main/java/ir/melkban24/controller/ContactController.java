package ir.melkban24.controller;

import ir.melkban24.model.Contact;
import ir.melkban24.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by mehdi on 5/24/17.
 */
@RestController
public class ContactController {
    @Autowired
    private static final Logger logger= LoggerFactory.getLogger(ContactController.class);
    @Autowired
    private ContactRepository contactRepository;

    /**
     * Get Contact
     * @param id
     * @return
     */
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        Contact contact=this.contactRepository.findOne(id);
        if(contact==null)
            return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Contact>(contact,HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/create", method = RequestMethod.POST)
    public ResponseEntity<?> addContact(@RequestBody Contact contact, UriComponentsBuilder ucBuilder, Authentication authentication) {
        logger.info("Username: {}",authentication.getName());
        this.contactRepository.save(contact);
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(ucBuilder.path("/contact/{id}").buildAndExpand(contact.getId()).toUri());
        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
    }
}