package com.example.CrudBook.service;

import com.example.CrudBook.model.Institution.Workplace;
import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class WorkplaceService {
    @Autowired
    WorkplaceRepository workplaceRepository;


    public void saveWorkplace(Workplace workplace) {
        workplaceRepository.save(workplace);
    }

    public void transformToBase64(List<Workplace> workplaceList) {
        for(Workplace workplace : workplaceList){
            workplace.setBase64(Base64.getEncoder().encodeToString(workplace.getImage()));
        }
    }
}
