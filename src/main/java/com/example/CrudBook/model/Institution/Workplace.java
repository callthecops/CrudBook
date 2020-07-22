package com.example.CrudBook.model.Institution;

import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String type;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "work_image")
    private byte[] image;

    @OneToMany(mappedBy = "workplace", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

}
