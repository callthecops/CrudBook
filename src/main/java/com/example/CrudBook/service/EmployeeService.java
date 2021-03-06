package com.example.CrudBook.service;

import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.model.User.UserForm;
import com.example.CrudBook.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void transformToBase64(List<Employee> employees){
        for(Employee employee : employees){
            employee.setBase64(Base64.getEncoder().encodeToString(employee.getImage()));
        }
    }

    public Employee updateEmployee(Employee employee, UserForm userForm, byte[] image){
        employee.setFirstName(userForm.getFirstName());
        employee.setLastName(userForm.getLastName());
        employee.setAge(userForm.getAge());
        employee.setSpecialisation(userForm.getSpecialisation());
        employee.setImage(image);
        employee.setDescription(userForm.getDescription());

        return employee;
    }

}
