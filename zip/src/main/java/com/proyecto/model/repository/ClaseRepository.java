package com.proyecto.model.repository;

import com.proyecto.model.entity.Asignatura;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.Profesor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ClaseRepository extends CrudRepository<Clase,Long> {

    @Query("SELECT c FROM Clase c " +
            "JOIN c.asignatura a " +
            "JOIN c.semestre s " +
            "WHERE s.profesor = :profesor " +
            "AND a.id = :asignatur ")
    List<Clase> getClasePorProfesor(@Param("profesor") Profesor profesor,@Param("asignatur") long id);

}
