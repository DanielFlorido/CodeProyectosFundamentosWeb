package com.proyecto.model.service;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.Estudiante;
import com.proyecto.model.entity.ListaNotas;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.repository.EstudianteRepository;
import com.proyecto.model.repository.ListaNotasRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    ListaNotasRepository listaNotasRepository;
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

    public void deleteEstudiante(long id){
        estudianteRepository.deleteById(id);
    }

    public Long getListaNotasId(Long idEstudiante){
        return estudianteRepository.getListaNotasId(idEstudiante);
    }

    public void deleteListaNotas(Long idListaNotas){

        estudianteRepository.deleteNotas(idListaNotas);
        estudianteRepository.deleteListaNotas(idListaNotas);
    }

    public void modificarEstudiante(Long idEstudiante, String nombre, String apellido){

        estudianteRepository.modificarEstudiante(idEstudiante, nombre, apellido);
    }

    public List<Clase> otrasClases(Long estudianteId){
        return estudianteRepository.otrasClases(estudianteId);
    }

    public void agregarAClase(Estudiante estudiante, Clase clase){
        ListaNotas listaNotas = new ListaNotas();
        listaNotas.setNotas(null);
        listaNotas.setEstudiante(estudiante);
        listaNotas.setClase(clase);

        listaNotasRepository.save(listaNotas);
    }

    public Clase getClase(Long idClase){
        return estudianteRepository.getClase(idClase);
    }
}
