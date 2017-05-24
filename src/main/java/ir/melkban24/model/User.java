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

    private Long id;
    private String username;
    private String password;
    private String email;
    private UserModelStatus status;
    private Set<Role> roles;
    //private Agent agent;

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

    //@JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Enumerated(EnumType.ORDINAL)
    public UserModelStatus getStatus() {
        return status;
    }

    public void setStatus(UserModelStatus status) {
        this.status = status;
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

    /*
    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    */
}
