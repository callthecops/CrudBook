package com.example.CrudBook.model.Institution;

import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Workplace implements Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String type;

    private String base64;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "work_image")
    private byte[] image;

    @OneToMany(mappedBy = "workplace", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    public Workplace(Long id, String name, String address, String type, byte[] image, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.image = image;
        this.employees = employees;
    }

    public Workplace() {
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
