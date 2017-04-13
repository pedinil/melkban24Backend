package ir.melkban24.service;

import ir.melkban24.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mehdi on 3/16/17.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public User userInfo(@PathVariable("name") String username) {
        return userService.findByUsername(username);
    }
}