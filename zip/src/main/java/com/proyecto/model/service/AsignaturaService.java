package com.proyecto.model.service;
import java.util.List;
import java.util.NoSuchElementException;
import com.proyecto.model.entity.Asignatura;
import com.proyecto.model.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {
    @Autowired
    AsignaturaRepository asignaturaRepository;

    public List<Asignatura> getAsignaturas(){
        return (List<Asignatura>) asignaturaRepository.findAll();
    }

    public Asignatura getAsignatura(long id){
        try{
            return asignaturaRepository.findById(id).orElseThrow();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public void addAsignatura(Asignatura pAsignatura){
        asignaturaRepository.save(pAsignatura);
    }

    public void deleteAsignatura(long id){
        asignaturaRepository.deleteById(id);
    }
}
