package io.github.notfoundry.lab6.model;

import jakarta.persistence.*;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
    @RestResource(exported = false)
    private List<BuddyInfo> buddies = new ArrayList<>();

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean addBuddy(final BuddyInfo b) {
        return this.buddies.add(b);
    }

    public boolean removeBuddy(final BuddyInfo b) {
        return this.buddies.remove(b);
    }

    public boolean hasBuddy(final BuddyInfo b) {
        return this.buddies.contains(b);
    }

    public int size() {
        return this.buddies.size();
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "id=" + id +
                ", buddies=" + buddies +
                '}';
    }
}
