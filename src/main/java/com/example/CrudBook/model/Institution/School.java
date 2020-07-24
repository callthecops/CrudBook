package com.example.CrudBook.model.Institution;


import com.example.CrudBook.model.User.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School implements Institution{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String type;

    private String base64;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "school_image")
    private byte[] image;

    @OneToMany(mappedBy = "school", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();


    public School(Long id, String name, String address, String type, byte[] image, List<Student> students) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.image = image;
        this.students = students;
    }


    public School() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
