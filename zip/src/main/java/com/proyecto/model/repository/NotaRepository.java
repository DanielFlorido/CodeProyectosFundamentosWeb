package com.proyecto.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Nota;

@Repository
public interface NotaRepository extends CrudRepository<Nota,Long>{
    
}
