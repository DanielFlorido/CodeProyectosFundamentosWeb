package com.proyecto.model.repository;

import com.proyecto.model.entity.Clase;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Estudiante;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante,Long> {

    @Query("SELECT lns.id FROM ListaNotas lns " +
            "WHERE lns.estudiante.id = :idEstudiante ")
    Long getListaNotasId(@Param("idEstudiante") Long idEstudiante);
    @Transactional
    @Modifying
    @Query("DELETE FROM Nota nota " +
            "WHERE nota.listaNotas.id = :idListaNotas ")
    void deleteNotas(@Param("idListaNotas") Long idListaNotas);

    @Transactional
    @Modifying
    @Query("DELETE FROM ListaNotas listanota " +
            "WHERE listanota.id = :idListaNotas ")
    void deleteListaNotas(@Param("idListaNotas") Long idListaNotas);

    @Modifying
    @Query("UPDATE Estudiante estudiante " +
            "SET estudiante.nombre = :nombre, estudiante.apellido = :apellido " +
            "WHERE estudiante.id = :idEstudiante ")
    void modificarEstudiante(@Param("idEstudiante") Long idEstudiante, @Param("nombre") String nombre, @Param("apellido") String apellido);

    @Query("SELECT c " +
            "FROM Clase c " +
            "LEFT JOIN ListaNotas listaNotas ON c.id = listaNotas.clase.id AND listaNotas.estudiante.id = :idEstudiante " +
            "WHERE listaNotas.estudiante.id IS NULL")
    List<Clase> otrasClases(@Param("idEstudiante") Long idEstudiante);

    @Query("SELECT c " +
            "FROM Clase c " +
            "WHERE c.id = :idClase")
    Clase getClase(@Param("idClase") Long idClase);

}
