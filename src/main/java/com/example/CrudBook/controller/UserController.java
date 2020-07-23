package com.example.CrudBook.controller;

import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.model.User.User;
import com.example.CrudBook.model.User.UserForm;
import com.example.CrudBook.repository.EmployeeRepository;
import com.example.CrudBook.repository.StudentRepository;
import com.example.CrudBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@Validated
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public String getAllUsers(Model model) {

        List<Student> studentList = studentRepository.findAll();
        List<Employee> employeeList = employeeRepository.findAll();

        model.addAttribute("studentlist", studentList);
        model.addAttribute("employeelist", employeeList);

        return "users";
    }

    //retrieves only the user form
    @GetMapping("/addUser")
    public String getUserAddForm() {
        return "adduserform";
    }


    //Splits the info added by the user into Student or Employee and redirect accordingly
    //For this method to work, we have to add @Valid on the parameter to check for contraints and @Validated
    //on the controller.At the same time we have to retrieve the image sepparately so userform has no image field.
    @PostMapping("/addUser")
    public String differentiateUsers(@RequestPart("image") byte[] image, @Valid UserForm userForm, Errors errors, RedirectAttributes model) {

        if (errors.hasErrors()) {
            return "adduserform";
        }

        User user = userService.diffUsers(userForm, image);
        //depending to what class user is instance of i redirect to different endpoints by using flashattributes
        //wich survive a redirect.
        if (user instanceof Student) {
            model.addFlashAttribute("student", user);
            return "redirect:/student/saveStudent";
        } else {
            model.addFlashAttribute("employee", user);
            return "redirect:/institution/saveInstitution";

        }
    }


}
