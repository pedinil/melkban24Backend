package ir.melkban24.repository;

import ir.melkban24.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mehdi on 3/12/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
