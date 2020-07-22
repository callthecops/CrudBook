package com.example.CrudBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/institutions")
public class InstitutionController {

    @GetMapping
    public String getInstitution() {
        return "institutions";
    }

    @GetMapping("/addInstitution")
    public String getInstitutionAddForm() {
        return "addinstitutionform";
    }

    //Splits the info added by the user into Workplace or school and redirect accordingly
    @PostMapping("/addInstitution")
    public String differentiateInstitutions() {
        return new String();
    }
}
