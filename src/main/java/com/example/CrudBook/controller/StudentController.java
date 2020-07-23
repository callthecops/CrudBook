package com.example.CrudBook.controller;

import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.repository.StudentRepository;
import com.example.CrudBook.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;

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



//
//    @PostMapping("/updateUser")
//    public void updateUser() {
//    }
//
//    @GetMapping("/deleteUser")
//    public void deleteUser() {
//    }
//
//    @GetMapping("/findUser")
//    public void retrieveUser() {
//    }
//
//    @GetMapping("/findUsers")
//    public void retrieveUsers() {
//    }
}
