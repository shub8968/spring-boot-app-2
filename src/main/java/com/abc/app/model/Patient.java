package com.abc.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private java.lang.String name;
    private String contactNumber;

    public Patient(String id, java.lang.String name, String contactNumber) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contactNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
