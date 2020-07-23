package com.example.CrudBook.service;

import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

}
