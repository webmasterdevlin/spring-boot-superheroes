package com.example.superheroes.hero.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Hero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "First Name is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "name must be a string")
    private String firstName;

    private String lastName;
    private String house;
    private String knownAs;

    public Hero(
            UUID id,
            String firstName,
            String lastName,
            String house,
            String knownAs
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.house = house;
        this.knownAs = knownAs;
    }

    // hero.lastName = "Duldulao";
    // hero.setLastName = "Devlin"

    public Hero() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    @Override
    public String toString() {
        return (
                "Hero{" +
                        "id=" +
                        id +
                        ", firstName='" +
                        firstName +
                        '\'' +
                        ", lastName='" +
                        lastName +
                        '\'' +
                        ", house='" +
                        house +
                        '\'' +
                        ", knownAs='" +
                        knownAs +
                        '\'' +
                        '}'
        );
    }
}
