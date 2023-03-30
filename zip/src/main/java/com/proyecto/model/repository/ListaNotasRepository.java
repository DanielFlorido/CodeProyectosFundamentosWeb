package com.proyecto.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.ListaNotas;

@Repository
public interface ListaNotasRepository extends CrudRepository<ListaNotas,Long> {
    
}
