package com.example.CrudBook.repository;

import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.User.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();

    Student findById(long id);

    List<Student> findAllBySchool(School school);
}
