package com.netcracker.application.model.system;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @Column(length = 5)
    private String id;

    @Column(name="surname")
    private String surname;

    @Column(name="name")
    private String name;

    @Column(name="patronymic")
    private String patronymic;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service service;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "billingAccounts_id", referencedColumnName = "id")
    private BillingAcc billingAcc;

    public Client() {
    }

    public Client(String id, String surname, String name, String patronymic, String phoneNumber, Address address, Service service, BillingAcc billingAcc) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.service = service;
        this.billingAcc = billingAcc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public BillingAcc getBillingAcc() {
        return billingAcc;
    }

    public void setBillingAcc(BillingAcc billingAcc) {
        this.billingAcc = billingAcc;
    }
}

