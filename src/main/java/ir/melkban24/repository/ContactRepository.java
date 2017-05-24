package ir.melkban24.repository;

import ir.melkban24.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by mehdi on 5/24/17.
 */
public interface ContactRepository extends JpaRepository<Contact,Long>{

}
