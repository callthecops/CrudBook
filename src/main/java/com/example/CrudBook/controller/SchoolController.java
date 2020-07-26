package com.example.CrudBook.controller;

import com.example.CrudBook.model.Institution.InstitutionForm;
import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.Institution.Workplace;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.model.User.UserForm;
import com.example.CrudBook.repository.SchoolRepository;
import com.example.CrudBook.repository.StudentRepository;
import com.example.CrudBook.service.SchoolService;
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
import java.util.List;
import java.util.Map;

@Controller
@Validated
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;
    @Autowired
    StudentService studentService;
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/saveSchool")
    public String saveSchool(HttpServletRequest request, Model model) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            School school = (School) inputFlashMap.get("school");
            schoolService.saveSchool(school);

            return "redirect:/institutions";
        }
        return "addinstitutionform";
    }

    @GetMapping("/delete/{id}")
    public String deleteSchool(@PathVariable("id") long id, Model model) {

        School school = schoolRepository.findById(id);
        List<Student> studentList = studentRepository.findAllBySchool(school);
        if (!studentList.isEmpty()) {
            for (Student student : studentList) {
                student.setSchool(null);
                studentService.saveStudent(student);
            }
            schoolRepository.delete(school);
        }
        return "redirect:/institutions";
    }


    @GetMapping("/editschool/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        School school = schoolRepository.findById(id);
        model.addAttribute("school", school);
        return "updateschoolform";
    }


    @PostMapping("/updateschool/{id}")
    public String updateTheSchool(@RequestPart("image") byte[] image, @Valid InstitutionForm institutionForm, Errors errors, @PathVariable("id") long id) {

        if (errors.hasErrors()) {
            return "redirect:/school/editschool/" + id;
        }
        School school = schoolRepository.findById(id);
        schoolRepository.save(schoolService.updateSchool(school, institutionForm, image));


        return "redirect:/institutions";
    }

}
