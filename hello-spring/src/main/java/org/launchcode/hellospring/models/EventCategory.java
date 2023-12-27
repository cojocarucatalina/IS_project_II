package org.launchcode.hellospring.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class EventCategory extends AbstractEntity {


    @NotBlank
    @Size(min = 3, max =50)
    private String name;

    public EventCategory(){}

    public EventCategory(@Size(min =3, message = "Name must be 3 characters long") String name) {
        this.name = name;

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

}
