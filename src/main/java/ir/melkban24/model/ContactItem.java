package ir.melkban24.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mehdi on 5/24/17.
 */
@Entity
@Table(name = "contact_item")
public class ContactItem {
    private Long id;
    private ContactItemType type;
    private String value;
    private Contact contact;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.ORDINAL)
    public ContactItemType getType() {
        return type;
    }

    public void setType(ContactItemType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_contact_id")
    public Contact getContact() {
        return contact;
    }
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
