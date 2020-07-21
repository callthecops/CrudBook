package com.example.CrudBook.model.User;

import com.example.CrudBook.model.Institution.Institution;

import javax.persistence.*;

@Entity
public class Employee implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private String specialisation;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "employee_image")
    private byte[] image;

    @ManyToOne
    private Institution institution;

    private String description;

}
