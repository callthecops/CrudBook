package com.example.CrudBook.model.Institution;

import com.example.CrudBook.model.User.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Workplace implements Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    private String type;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "work_image")
    private byte[] image;

    @OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

}
