package com.proyecto.model.repository;

import com.proyecto.model.entity.Profesor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Asignatura;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AsignaturaRepository extends CrudRepository<Asignatura,Long>{
    @Query("SELECT DISTINCT a FROM Asignatura a " +
            "JOIN a.clases c " +
            "JOIN c.semestre s " +
            "WHERE s.profesor = :profesor")
    List<Asignatura> getAsignaturasPorProfesor(@Param("profesor") Profesor profesor);


}
