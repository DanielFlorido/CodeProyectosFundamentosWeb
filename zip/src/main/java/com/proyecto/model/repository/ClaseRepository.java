package com.proyecto.model.repository;

import com.proyecto.model.entity.Asignatura;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.Profesor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClaseRepository extends CrudRepository<Clase,Long> {

    //no lo he probado
    @Query("SELECT c FROM Clase c " +
            "JOIN c.asignatura a " +
            "JOIN c.semestre s " +
            "WHERE s.profesor = :profesor " +
            "AND a.id = :asignatur ")
    List<Clase> getClasePorProfesor(@Param("profesor") Profesor profesor,@Param("asignatur") long id);

    @Query("SELECT lns.id FROM ListaNotas lns " +
            "WHERE lns.clase.id = :idClase ")
    List<Long> ListaNotasId(@Param("idClase") Long idClase);

    @Transactional
    @Modifying
    @Query("DELETE FROM Nota nota " +
            "WHERE nota.listaNotas.id IN (:idListaNotas) ")
    void deleteNotas(@Param("idListaNotas") List<Long> idListaNotas);

    @Transactional
    @Modifying
    @Query("DELETE FROM ListaNotas listaNota " +
            "WHERE listaNota.clase.id = :idClase ")
    void deleteListaNotas(@Param("idClase") Long idClase);


}
