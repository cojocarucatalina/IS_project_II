package org.launchcode.hellospring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity{

    private EventCategory eventCategory;

    @NotBlank
    @Size(min = 3, max =50)
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;


    public String getContactEmail() {
        return contactEmail;
    }

    @NotBlank
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    public Event(){}

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Event(String name, String description, EventCategory eventCategory, String contactEmail) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.eventCategory = eventCategory;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public void setType(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }
}
