package ir.melkban24.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mehdi on 3/12/17.
 */
@Entity
@Table(name = "role")
public class Role {
    /**
     *
     +-------+-------------+------+-----+---------+----------------+
     | Field | Type        | Null | Key | Default | Extra          |
     +-------+-------------+------+-----+---------+----------------+
     | id    | int(11)     | NO   | PRI | NULL    | auto_increment |
     | name  | varchar(45) | YES  |     | NULL    |                |
     +-------+-------------+------+-----+---------+----------------+
     */
    private Long id;
    private String name;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonIgnore
    @ManyToMany( mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
