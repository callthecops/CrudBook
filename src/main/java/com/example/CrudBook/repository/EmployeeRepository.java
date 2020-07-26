package com.example.CrudBook.repository;

import com.example.CrudBook.model.Institution.Workplace;
import com.example.CrudBook.model.User.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();

    Employee findById(long id);

    List<Employee> findAllByWorkplace(Workplace workplace);
}
