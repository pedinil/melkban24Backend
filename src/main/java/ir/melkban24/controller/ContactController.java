package ir.melkban24.controller;

import ir.melkban24.model.Agent;
import ir.melkban24.model.Contact;
import ir.melkban24.repository.AgentRepository;
import ir.melkban24.repository.ContactRepository;
import ir.melkban24.service.AgentService;
import ir.melkban24.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.Response;

/**
 * Created by mehdi on 5/24/17.
 */
@RestController
public class ContactController {
    @Autowired
    private static final Logger logger= LoggerFactory.getLogger(ContactController.class);
    @Autowired
    private ContactService contactService;

    @Autowired
    private AgentService agentService;

    /**
     * Get Contacts List for agent
     * @param pageable
     * @param authentication
     * @return
     */
 /*   @RequestMapping(value = "/contact/list",method = RequestMethod.GET)
    public Page<Contact> getContacts(Pageable pageable,Authentication authentication)
    {
        Agent agent=this.agentService.findByAgentUsername(authentication.getName());
        return this.contactService.findAllByAgent_id(agent.getId(),pageable);
    }*/
    /**
     * Get Contact
     * @param id
     * @return
     */
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        Contact contact=this.contactService.findByContactId(id);
        if(contact==null)
            return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Contact>(contact,HttpStatus.OK);
    }

    /**
     * Create Contact
     * @param contact
     * @param ucBuilder
     * @param authentication
     * @return
     */
    @RequestMapping(value = "/contact/create", method = RequestMethod.POST)
    public ResponseEntity<?> addContact(@RequestBody Contact contact, UriComponentsBuilder ucBuilder, Authentication authentication) {
        logger.info("Username: {}",authentication.getName());
        Agent agent=this.agentService.findByAgentUsername(authentication.getName());
        contact.setAgent(agent);
        this.contactService.save(contact);
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(ucBuilder.path("/contact/{id}").buildAndExpand(contact.getId()).toUri());
        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
    }

    /**
     * Delete Contact
     * @param id
     * @param authentication
     * @return
     */
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteContact(@PathVariable Long id, Authentication authentication)
    {
        Contact contact = this.contactService.findByContactId(id);
        if(contact==null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        Agent agent=this.agentService.findByAgentUsername(authentication.getName());
        if(contact.getAgent().getId()!=agent.getId())
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        this.contactService.delete(contact);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /**
     * Update Contact
     * @param id
     * @param contact
     * @param authentication
     * @return
     */
    @RequestMapping(value = "/contact/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact,Authentication authentication)
    {
        Contact currentContact = this.contactService.findByContactId(id);
        if(currentContact==null)
            return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
        Agent agent=this.agentService.findByAgentUsername(authentication.getName());
        if(currentContact.getAgent().getId()!=agent.getId())
            return new ResponseEntity<Contact>(HttpStatus.FORBIDDEN);

        currentContact.setAddress(contact.getAddress());
        currentContact.setFirstname(contact.getFirstname());
        currentContact.setLastname(contact.getLastname());
        currentContact.setMobile(contact.getMobile());
        currentContact.setPhone(contact.getPhone());
        currentContact.setZipcode(contact.getZipcode());
        this.contactService.update(contact);
        return new ResponseEntity<Contact>(currentContact,HttpStatus.OK);
    }
}
