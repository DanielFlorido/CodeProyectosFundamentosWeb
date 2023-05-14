package com.proyecto.model.repository;

import com.proyecto.model.entity.Profesor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Asignatura;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface  AsignaturaRepository extends CrudRepository<Asignatura,Long>{
    @Query("SELECT DISTINCT a FROM Asignatura a " +
            "JOIN a.clases c " +
            "JOIN c.semestre s " +
            "WHERE s.profesor = :profesor")
    List<Asignatura> getAsignaturasPorProfesor(@Param("profesor") Profesor profesor);
    @Transactional
    @Modifying
    @Query("DELETE FROM Clase clase " +
            "WHERE clase.asignatura.id = :idAsignatura ")
    void eliminarClaseAsignatura(@Param("idAsignatura") long idAsignatura);

    @Query("SELECT clase.id FROM Clase clase " +
            "WHERE clase.asignatura.id = :idAsignatura ")
    List<Long> getClasesId(@Param("idAsignatura") Long idAsignatura);

    @Query("SELECT listaNotas.id FROM ListaNotas listaNotas " +
            "WHERE listaNotas.clase.id IN (:idClase) ")
    List<Long> listaNotasId(@Param("idClase") List<Long> idClase);

    @Transactional
    @Modifying
    @Query("DELETE FROM Nota nota " +
            "WHERE nota.listaNotas.id IN (:idListaNotas) ")
    void deleteNotas(@Param("idListaNotas") List<Long> idListaNotas);

    @Transactional
    @Modifying
    @Query("DELETE FROM ListaNotas listaNota " +
            "WHERE listaNota.clase.id IN (:idClases) ")
    void deleteListaNotas(@Param("idClases") List<Long> idClases);
}
