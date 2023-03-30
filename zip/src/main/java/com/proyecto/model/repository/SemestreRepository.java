package com.proyecto.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.entity.Semestre;

@Repository
public interface SemestreRepository extends CrudRepository<Semestre,Long> {
    
}
