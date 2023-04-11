package com.proyecto.model.repository;

import com.proyecto.model.entity.Asignatura;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.ListaNotas;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ListaNotasRepository extends CrudRepository<ListaNotas,Long> {
    @Query("SELECT e.nombre, a.nombre as asignatura, n.descripcion, n.nota, n.porcentaje " +
            "FROM Clase c " +
            "INNER JOIN c.asignatura a " +
            "INNER JOIN c.estudiantes e " +
            "INNER JOIN c.notasClase l " +
            "INNER JOIN l.notas n " +
            "WHERE c.idClase = :idClase")
    List<ListaNotas> getListaNotasPorClase(@Param("idClase") Clase idClase);
}
