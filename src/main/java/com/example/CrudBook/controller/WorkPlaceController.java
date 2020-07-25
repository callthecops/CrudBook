package com.example.CrudBook.controller;

import com.example.CrudBook.model.Institution.InstitutionForm;
import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.Institution.Workplace;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.repository.WorkplaceRepository;
import com.example.CrudBook.service.WorkplaceService;
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
@RequestMapping("/workplace")
public class WorkPlaceController {


    @Autowired
    WorkplaceService workplaceService;
    @Autowired
    WorkplaceRepository workplaceRepository;

    @GetMapping("/saveWorkplace")
    public String saveWorkplace(HttpServletRequest request, Model model) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            Workplace workplace = (Workplace) inputFlashMap.get("workplace");
            workplaceService.saveWorkplace(workplace);

            return "redirect:/institutions";
        }
        return "addinstitutionform";
    }


    @GetMapping("/delete/{id}")
    public String deleteWorkplace(@PathVariable("id") long id, Model model) {

        Workplace workplace = workplaceRepository.findById(id);
        workplaceRepository.delete(workplace);

        return "redirect:/institutions";
    }


    @GetMapping("/editworkplace/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        Workplace workplace = workplaceRepository.findById(id);
        model.addAttribute("workplace", workplace);
        return "updateworkplaceform";
    }


    @PostMapping("/updateworkplace/{id}")
    public String updateTheWorkplace(@RequestPart("image") byte[] image, @Valid InstitutionForm institutionForm, Errors errors, @PathVariable("id") long id) {

        if (errors.hasErrors()) {
            return "redirect:/workplace/editworkplace/" + id;
        }
        Workplace workplace = workplaceRepository.findById(id);
        workplaceRepository.save(workplaceService.updateWorkplace(workplace,institutionForm,image));


        return "redirect:/institutions";
    }
}
