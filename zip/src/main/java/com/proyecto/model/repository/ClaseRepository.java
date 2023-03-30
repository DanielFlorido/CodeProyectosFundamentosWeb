package com.proyecto.model.repository;

import com.proyecto.model.entity.Clase;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public interface ClaseRepository extends CrudRepository<Clase,Long> {
    
}
