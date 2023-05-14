package com.proyecto.model.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.proyecto.model.entity.Asignatura;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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
    public List<Asignatura> getAsignaturasPorProfesor(Profesor profesor){
        return asignaturaRepository.getAsignaturasPorProfesor(profesor);
    }
}
