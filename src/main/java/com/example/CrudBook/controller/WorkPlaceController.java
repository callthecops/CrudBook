package com.example.CrudBook.controller;

import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.Institution.Workplace;
import com.example.CrudBook.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Validated
@RequestMapping("/workplace")
public class WorkPlaceController {


    @Autowired
    WorkplaceService workplaceService;


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


}
