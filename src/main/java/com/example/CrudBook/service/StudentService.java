package com.example.CrudBook.service;

import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.model.User.UserForm;
import com.example.CrudBook.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Base64;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void transformToBase64(List<Student> studentList){
        for(Student student :studentList){
            student.setBase64(Base64.getEncoder().encodeToString(student.getImage()));
        }
    }

    public Student updateStudent(Student student,UserForm userForm, byte[] image){
        student.setFirstName(userForm.getFirstName());
        student.setLastName(userForm.getLastName());
        student.setAge(userForm.getAge());
        student.setSpecialisation(userForm.getSpecialisation());
        student.setImage(image);
        student.setDescription(userForm.getDescription());

        return student;
    }

}
