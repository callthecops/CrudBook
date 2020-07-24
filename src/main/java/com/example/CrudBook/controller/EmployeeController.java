package com.example.CrudBook.controller;

import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.model.User.UserForm;
import com.example.CrudBook.repository.EmployeeRepository;
import com.example.CrudBook.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/saveEmployee")
    public String saveEmployee(HttpServletRequest request, Model model) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            Employee employee = (Employee) inputFlashMap.get("employee");
            employeeService.saveEmployee(employee);
            return "redirect:/users";
        }
        return "adduserform";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model) {

        Employee employee = employeeRepository.findById(id);
        employeeRepository.delete(employee);

        return "redirect:/users";
    }


    @GetMapping("/editemployee/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        Employee employee = employeeRepository.findById(id);
        model.addAttribute("employee", employee);
        return "updateemployeeform";
    }


    @PostMapping("/updateemployee/{id}")
    public String updateTheEmployee(@RequestPart("image") byte[] image, @Valid UserForm userForm, Errors errors, @PathVariable("id") long id) {

        if (errors.hasErrors()) {
            return "redirect:/employee/editemployee/" + id;
        }
        Employee employee = employeeRepository.findById(id);
        employeeRepository.save(employeeService.updateEmployee(employee, userForm, image));


        return "redirect:/users";
    }

}
