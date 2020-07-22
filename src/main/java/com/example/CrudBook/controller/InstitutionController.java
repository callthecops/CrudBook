package com.example.CrudBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/institutions")
public class InstitutionController {

    @GetMapping
    public String getInstitution() {
        return "institutions";
    }

}
