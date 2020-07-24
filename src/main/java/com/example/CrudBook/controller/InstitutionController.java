package com.example.CrudBook.controller;

import com.example.CrudBook.model.Institution.Institution;
import com.example.CrudBook.model.Institution.InstitutionForm;
import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.Institution.Workplace;
import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.model.User.User;
import com.example.CrudBook.model.User.UserForm;
import com.example.CrudBook.repository.SchoolRepository;
import com.example.CrudBook.repository.WorkplaceRepository;
import com.example.CrudBook.service.InstitutionService;
import com.example.CrudBook.service.SchoolService;
import com.example.CrudBook.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@Validated
@RequestMapping("/institutions")
public class InstitutionController {

    @Autowired
    InstitutionService institutionService;

    @Autowired
    WorkplaceService workplaceService;
    @Autowired
    SchoolService schoolService;

    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    WorkplaceRepository workplaceRepository;

    @GetMapping
    public String getInstitution(Model model) {

        List<School> schoolList = schoolRepository.findAll();
        List<Workplace> workplaceList = workplaceRepository.findAll();

        schoolService.transformToBase64(schoolList);
        workplaceService.transformToBase64(workplaceList);

        model.addAttribute("schoollist", schoolList);
        model.addAttribute("workplacelist", workplaceList);


        return "institutions";
    }

    @GetMapping("/addInstitution")
    public String getInstitutionAddForm() {
        return "addinstitutionform";
    }


    //Splits the info added by the user into Workplace or school and redirect accordingly
    @PostMapping("/addInstitution")
    public String differentiateInstitutions(@RequestPart("image") byte[] image, @Valid InstitutionForm institutionForm, Errors errors, RedirectAttributes model) {
        if (errors.hasErrors()) {
            return "addinstitutionform";
        }
        Institution institution = institutionService.diffInstitutions(institutionForm, image);
        //depending to what class user is instance of i redirect to different endpoints by using flashattributes
        //wich survive a redirect.
        if (institution instanceof School) {
            model.addFlashAttribute("school", institution);
            return "redirect:/school/saveSchool";
        } else {
            model.addFlashAttribute("workplace", institution);
            return "redirect:/workplace/saveWorkplace";
        }
    }
}
