package ir.melkban24.service;

import ir.melkban24.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by mehdi on 3/13/17.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
