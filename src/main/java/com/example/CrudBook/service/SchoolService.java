package com.example.CrudBook.service;

import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public void saveSchool(School school){
        schoolRepository.save(school);
    }


    public void transformToBase64(List<School> schoolList) {
        for(School school : schoolList){
            school.setBase64(Base64.getEncoder().encodeToString(school.getImage()));
        }
    }
}
