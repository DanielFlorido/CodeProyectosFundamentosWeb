package com.proyecto.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Estudiante;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante,Long> {

}
