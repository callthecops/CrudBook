package com.example.CrudBook.repository;

import com.example.CrudBook.model.Institution.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
    List<School> findAll();

    School findById(long id);
}

