package com.example.CrudBook.repository;

import com.example.CrudBook.model.Institution.Workplace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceRepository extends CrudRepository <Workplace,Long> {
}
