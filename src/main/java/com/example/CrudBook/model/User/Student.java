package com.example.CrudBook.model.User;

import com.example.CrudBook.model.Institution.School;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Student implements User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private int age;
    @NotBlank
    private String specialisation;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "employee_image")
    private byte[] image;


    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_school")
    private School school;

    private String description;

    private String base64;

    public Student(Long id, String firstName, String lastName, int age, String specialisation, byte[] image, School school, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.specialisation = specialisation;
        this.image = image;
        this.school = school;
        this.description = description;
    }

    public Student() {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
