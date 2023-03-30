package com.proyecto.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Asignatura;

@Repository
public interface AsignaturaRepository extends CrudRepository<Asignatura,Long>{
    
}
