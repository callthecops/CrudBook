package com.example.CrudBook.model.User;

import com.example.CrudBook.model.Institution.Workplace;

import javax.persistence.*;

@Entity
public class Employee {
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_workplace")
    private Workplace workplace;

    private String description;

}
