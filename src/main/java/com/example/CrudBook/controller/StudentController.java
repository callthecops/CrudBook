package com.example.CrudBook.controller;

import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.model.User.User;
import com.example.CrudBook.model.User.UserForm;
import com.example.CrudBook.repository.SchoolRepository;
import com.example.CrudBook.repository.StudentRepository;
import com.example.CrudBook.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Controller
@Validated
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SchoolRepository schoolRepository;

    //Implementing a redirect means having a 2 handler methods first with Post and second with Get.
    @GetMapping("/saveStudent")
    public String saveStudent(HttpServletRequest request, Model model) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            Student student = (Student) inputFlashMap.get("student");
            studentService.saveStudent(student);

            return "redirect:/users";
        }
        return "adduserform";
    }

    @GetMapping("/editstudent/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        Student student = studentRepository.findById(id);
        model.addAttribute("student", student);
        return "updatestudentform";
    }


    @PostMapping("/updatestudent/{id}")
    public String updateTheStudent(@RequestPart("image") byte[] image, @Valid UserForm userForm, Errors errors, @PathVariable("id") long id) {

        if (errors.hasErrors()) {
            return "redirect:/student/editstudent/" + id;
        }
        Student student = studentRepository.findById(id);
        studentRepository.save(studentService.updateStudent(student, userForm, image));


        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {

        Student student = studentRepository.findById(id);
        studentRepository.delete(student);

        return "redirect:/users";
    }


    @GetMapping("/addschool/{schoolid}/{studentid}")
    public String addSchoolToStudent(@PathVariable("schoolid") long id, @PathVariable("studentid") long id2, Model model) {
        School school = schoolRepository.findById(id);
        Student student = studentRepository.findById(id2);
        student.setSchool(school);
        studentRepository.save(student);
        return "redirect:/users";
    }

}
