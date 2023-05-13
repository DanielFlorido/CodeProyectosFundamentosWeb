package com.proyecto.model.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Profesor;

import java.util.List;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor,Long>{

    @Modifying
    @Query("UPDATE Profesor profesor " +
            "SET profesor.nombre = :nombre, profesor.apellido = :apellido, profesor.userName = :username, profesor.password = :contrasena " +
            "WHERE profesor.id = :idProfesor ")
    void modificarProfesor(@Param("idProfesor") Long idProfesor, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("username") String username, @Param("contrasena") String contrasena);
    
}
