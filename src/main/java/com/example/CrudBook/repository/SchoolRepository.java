package com.example.CrudBook.repository;

import com.example.CrudBook.model.Institution.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SchoolRepository extends CrudRepository <School,Long> {
}

