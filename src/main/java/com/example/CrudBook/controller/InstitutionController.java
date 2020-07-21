package com.example.CrudBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Institution")
public class InstitutionController {


    @PostMapping("/saveInstitution")
    public void saveInstitution() {
    }

    @PostMapping("/updateInstitution")
    public void updateInstitution() {
    }

    @GetMapping("/deleteInstitution")
    public void deleteInstitution() {
    }

    @GetMapping("/findInstitution")
    public void retrieveInstitution() {
    }

    @GetMapping("/findInstitution")
    public void retrieveInstitutions() {
    }

}
