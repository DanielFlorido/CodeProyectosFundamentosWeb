package com.proyecto.model.repository;

import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.Profesor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Nota;

import java.util.List;

@Repository
public interface NotaRepository extends CrudRepository<Nota,Long>{

    @Query("SELECT DISTINCT n.descripcion " +
            "FROM Nota n " +
            "INNER JOIN ListaNotas listaN ON n.listaNotas.id = listaN.id " +
            "INNER JOIN Clase c ON listaN.clase.id = c.id " +
            "WHERE c.idClase = :id " +
            "ORDER BY listaN.estudiante.id")
    List<String> getDescripciones(@Param("id") int idClase);
    
}
