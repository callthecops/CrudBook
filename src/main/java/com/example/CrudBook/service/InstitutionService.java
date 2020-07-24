package com.example.CrudBook.service;

import com.example.CrudBook.model.Institution.Institution;
import com.example.CrudBook.model.Institution.InstitutionForm;
import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.Institution.Workplace;
import com.example.CrudBook.model.User.Employee;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {
    public Institution diffInstitutions(InstitutionForm institutionForm, byte[] image) {
        if (institutionForm.getInstitution().equals("school")) {
            School school = new School();
            school.setName(institutionForm.getName());
            school.setAddress(institutionForm.getAddress());
            school.setType("School");
            school.setImage(image);
            return school;
        } else {
            Workplace workplace = new Workplace();
            workplace.setName(institutionForm.getName());
            workplace.setAddress(institutionForm.getAddress());
            workplace.setType("Workplace");
            workplace.setImage(image);
            return workplace;
        }
    }
}
