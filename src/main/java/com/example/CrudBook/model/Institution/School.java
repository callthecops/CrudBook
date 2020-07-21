package com.example.CrudBook.model.Institution;


import com.example.CrudBook.model.User.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School implements Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "school_image")
    private byte[] image;

    @OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

}
