package com.rariom.rest.webservices.restfulwebservices.user;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Schema(description = "All about the user")
public class User {
    private Integer id;
    @Size(min=2, message = "Name should have at least 2 characters")
    @Schema(description = "Name should have at least 2 characters")
    private String name;
    @Past
    @Schema(description = "Birthdate cannot be in the current time")
    private Date birthdate;

    public User(Integer id, String name, Date birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
