package com.proyecto.model.repository;

import com.proyecto.model.entity.Clase;
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

    @Query("SELECT clase " +
            "FROM Clase clase " +
            "WHERE clase.semestre.id IS NULL")
    List<Clase> getClasesVacias();

    @Query("SELECT clase " +
            "FROM Clase clase " +
            "WHERE clase.semestre.id = :idProfesor ")
    List<Clase> getClasesProfesor(@Param("idProfesor") Long idProfesor);

    @Modifying
    @Query("UPDATE Clase clase " +
            "SET clase.semestre.id = :idProfesor " +
            "WHERE clase.id = :idClase ")
    void cambiarClase(@Param("idProfesor") Long idProfesor, @Param("idClase") Long idClase);

    @Modifying
    @Query("UPDATE Clase clase " +
            "SET clase.semestre.id = NULL " +
            "WHERE clase.id = :idClase ")
    void quitarDeClase(@Param("idClase") Long idClase);


}
