package com.proyecto.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor,Long>{
    
}
