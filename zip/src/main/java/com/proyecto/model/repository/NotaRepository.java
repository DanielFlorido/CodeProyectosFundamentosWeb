package com.proyecto.model.repository;

import com.proyecto.model.entity.Clase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Nota;

import java.util.List;

@Repository
public interface NotaRepository extends CrudRepository<Nota,Long>{
    @Query("SELECT n FROM Nota" +
            "JOIN n.listaNotas ln" +
            "JOIN ln.clase" +
            "WHERE c.id = :claseId")
    List<Nota> getNotas(@Param("Clase") Clase clase);
}
