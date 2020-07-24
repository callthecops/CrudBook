package com.example.CrudBook.model.User;

import com.example.CrudBook.model.Institution.School;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 16)
    private String firstName;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 16)
    private String lastName;

    private int age;
    @NotNull
    @Size(min=2,max=16)
    private String specialisation;

    @NotNull
    @Size(min=2,max=25)
    private String institution;
    @NotNull
    @Size(min=5,max=125)
    private String description;

    public UserForm(String firstName, String lastName, int age, String specialisation, String institution, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.specialisation = specialisation;

        this.institution = institution;
        this.description = description;
    }

    public UserForm() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }


    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
