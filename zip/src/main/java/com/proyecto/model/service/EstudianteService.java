package com.proyecto.model.service;
import com.proyecto.model.entity.Estudiante;
import com.proyecto.model.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;
    public Estudiante getEstudiante(long id){
        try{
            return estudianteRepository.findById(id).orElseThrow();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public List<Estudiante> getEstudiantes(){
        return (List<Estudiante>) estudianteRepository.findAll();
    }

    public void addEstudiante(Estudiante pEstudiante){
        estudianteRepository.save(pEstudiante);
    }

    public void deleteById(long id) { estudianteRepository.deleteById(id); }

    public Long getListaNotasId(Long idEstudiante){
        return estudianteRepository.getListaNotasId(idEstudiante);
    }

    public void deleteListaNotas(Long idListaNotas){

        estudianteRepository.deleteNotas(idListaNotas);
        estudianteRepository.deleteListaNotas(idListaNotas);
    }


}
