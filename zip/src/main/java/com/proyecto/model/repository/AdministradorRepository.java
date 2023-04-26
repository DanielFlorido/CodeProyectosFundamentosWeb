package com.proyecto.model.repository;

import com.proyecto.model.entity.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador,Long> {
}