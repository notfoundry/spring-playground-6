package io.github.notfoundry.lab6.model;


import jakarta.persistence.*;

@Entity
public class BuddyInfo {
    private String firstName;
    private String lastName;

    private String address;
    private String telephoneNum;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public BuddyInfo() {}

    public BuddyInfo(final String firstName, final String lastName, final String address, final String telephoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephoneNum = telephoneNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(final String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BuddyInfo{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNum='" + telephoneNum + '\'' +
                '}';
    }
}

