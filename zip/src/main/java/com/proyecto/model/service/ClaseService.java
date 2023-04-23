package com.proyecto.model.service;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.List;
@Service
public class ClaseService {
    @Autowired
    ClaseRepository claseRepository;

    public Clase getClase(long id){
        try{
            return claseRepository.findById(id).orElseThrow();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public List<Clase> getClases(){
        return (List<Clase>) claseRepository.findAll();
    }


    public void addClase(Clase pClase){
        claseRepository.save(pClase);
    }

    public void deleteClases(long id){
        claseRepository.deleteById(id);
    }

    public List<Clase> getClasesPorProfesor(Profesor profesor,long id){
        return claseRepository.getClasePorProfesor(profesor,id);
    }
}
