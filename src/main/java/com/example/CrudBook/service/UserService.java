package com.example.CrudBook.service;

import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.Institution.Workplace;
import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.model.User.User;
import com.example.CrudBook.model.User.UserForm;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User diffUsers(UserForm userForm, byte[] image) {
        if (userForm.getInstitution().equals("school")) {
            Student student = new Student();
            student.setAge(userForm.getAge());
            student.setSpecialisation(userForm.getSpecialisation());
            student.setFirstName(userForm.getFirstName());
            student.setLastName(userForm.getLastName());
            student.setDescription(userForm.getDescription());
            student.setImage(image);
            //student.setSchool(new School());
            return student;
        } else {
            Employee employee = new Employee();
            employee.setAge(userForm.getAge());
            employee.setSpecialisation(userForm.getSpecialisation());
            employee.setFirstName(userForm.getFirstName());
            employee.setLastName(userForm.getLastName());
            employee.setDescription(userForm.getDescription());
            employee.setImage(image);
           // employee.setWorkplace(new Workplace());
            return employee;
        }
    }
}
