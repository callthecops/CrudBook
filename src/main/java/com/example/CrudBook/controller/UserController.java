package com.example.CrudBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/User")
public class UserController {

    @PostMapping("/saveUser")
    public void saveUser() {
    }

    @PostMapping("/updateUser")
    public void updateUser() {
    }

    @GetMapping("/deleteUser")
    public void deleteUser() {
    }

    @GetMapping("/findUser")
    public void retrieveUser() {
    }

    @GetMapping("/findUsers")
    public void retrieveUsers() {
    }
}
