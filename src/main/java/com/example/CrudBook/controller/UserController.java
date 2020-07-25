package com.example.CrudBook.controller;

import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.Institution.Workplace;
import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.model.User.User;
import com.example.CrudBook.model.User.UserForm;
import com.example.CrudBook.repository.EmployeeRepository;
import com.example.CrudBook.repository.SchoolRepository;
import com.example.CrudBook.repository.StudentRepository;
import com.example.CrudBook.repository.WorkplaceRepository;
import com.example.CrudBook.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Base64;
import java.util.List;

@Controller
@Validated
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SchoolService schoolService;
    @Autowired
    WorkplaceService workplaceService;

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    WorkplaceRepository workplaceRepository;


    @GetMapping
    public String getAllUsers(Model model) {

        List<Student> studentList = studentRepository.findAll();
        List<Employee> employeeList = employeeRepository.findAll();

        studentService.transformToBase64(studentList);
        employeeService.transformToBase64(employeeList);

        List<School> schoolList = schoolRepository.findAll();
        List<Workplace> workplaceList = workplaceRepository.findAll();
        if (!schoolList.isEmpty()) {
            model.addAttribute("schoollist",schoolList);
        }
        if (!workplaceList.isEmpty()) {
            model.addAttribute("workplacelist",workplaceList);
        }

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
            return "redirect:/employee/saveEmployee";

        }
    }


}
