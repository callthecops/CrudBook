package com.example.CrudBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers() {

        return "users";
    }

    //retrieves only the user form
    @GetMapping("/addUser")
    public String getUserAddForm() {
        return "adduserform";
    }


    //Splits the info added by the user into Student or Employee and redirect accordingly
    @PostMapping("/addUser")
    public String differentiateUsers() {


        return new String();
    }
}
