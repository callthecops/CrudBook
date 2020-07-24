package com.example.CrudBook.controller;

import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Validated
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;


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

}
