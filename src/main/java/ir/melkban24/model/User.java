package ir.melkban24.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mehdi on 3/12/17.
 */
@Entity
@Table(name="user")
public class User {
/**
 *
 +----------+--------------+------+-----+---------+----------------+
 | Field    | Type         | Null | Key | Default | Extra          |
 +----------+--------------+------+-----+---------+----------------+
 | id       | int(11)      | NO   | PRI | NULL    | auto_increment |
 | username | varchar(255) | YES  |     | NULL    |                |
 | password | varchar(255) | YES  |     | NULL    |                |
 +----------+--------------+------+-----+---------+----------------+
 */
    private Long id;
    private String username;
    private String password;
    private Set<Role> roles;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //@JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
