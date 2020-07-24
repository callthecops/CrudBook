package com.example.CrudBook.controller;

import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.repository.EmployeeRepository;
import com.example.CrudBook.service.EmployeeService;
import com.example.CrudBook.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
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

}
