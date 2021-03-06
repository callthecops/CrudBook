package com.example.CrudBook.repository;

import com.example.CrudBook.model.Institution.Workplace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkplaceRepository extends CrudRepository<Workplace, Long> {
    List<Workplace> findAll();

    Workplace findById(long id);
}
