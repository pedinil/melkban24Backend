package ir.melkban24.service;

import ir.melkban24.model.Contact;
import ir.melkban24.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mehdi on 3/16/17.
 */
@RestController
public class UserController {
    @Autowired
    private final static Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @Autowired
    ContactService contactService;
    

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public User userInfo(@PathVariable("name") String username) {
        return userService.findByUsername(username);
    }

    @RequestMapping(value = "/contact/list",method = RequestMethod.GET)
    public List<Contact> get() {
        return this.contactService.findAll();
    }

}
