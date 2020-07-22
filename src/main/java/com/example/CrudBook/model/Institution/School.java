package com.example.CrudBook.model.Institution;


import com.example.CrudBook.model.User.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "school_image")
    private byte[] image;

    @OneToMany(mappedBy = "school", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

}
