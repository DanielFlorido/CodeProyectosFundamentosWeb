package com.proyecto.model.repository;

import com.proyecto.model.entity.Asignatura;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.ListaNotas;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public interface ListaNotasRepository extends CrudRepository<ListaNotas,Long> {
    @Query("SELECT CONCAT(listaN.estudiante.nombre,' ',listaN.estudiante.apellido), n.nota " +
            "FROM Nota n " +
            "INNER JOIN ListaNotas listaN ON n.listaNotas.id = listaN.id " +
            "INNER JOIN Clase c ON listaN.clase.id = c.id " +
            "WHERE c.idClase = :idClase " +
            "ORDER BY listaN.estudiante.id")
    List<String> getListaNotasPorClase(@Param("idClase") int idClase);


    @Query("SELECT COUNT (DISTINCT listaN.estudiante.nombre) " +
            "FROM Nota n " +
            "INNER JOIN ListaNotas listaN ON n.listaNotas.id = listaN.id " +
            "INNER JOIN Clase c ON listaN.clase.id = c.id " +
            "WHERE c.idClase = :idClase" )
    int cantidadEstudiantes(@Param("idClase") int idClase);




}
