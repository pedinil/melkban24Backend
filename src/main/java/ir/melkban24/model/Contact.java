package ir.melkban24.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mehdi on 5/24/17.
 */
@Entity
@Table(name = "contact")
public class Contact {
    private Long id;
    private Agent agent;
    private String firstname;
    private String lastname;
    private String phone;
    private String mobile;
    private String address;
    private String zipcode;
    private Set<ContactItem> contactItems;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    public Set<ContactItem> getContactItems() {
        return contactItems;
    }

    public void setContactItems(Set<ContactItem> contactItems) {
        this.contactItems = contactItems;
    }
}
