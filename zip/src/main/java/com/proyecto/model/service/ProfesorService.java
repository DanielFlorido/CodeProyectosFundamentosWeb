package com.proyecto.model.service;

import com.proyecto.model.entity.Asignatura;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.List;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;
    public List<Profesor> getProfesores(){
        return (List<Profesor>) profesorRepository.findAll();
    }

    public Profesor getProfesor(long id){
        try{
            return profesorRepository.findById(id).orElseThrow();
        }catch (NoSuchElementException e){
            return null;
        }
    }
    public void addProfesor(Profesor pProfesor){
        profesorRepository.save(pProfesor);
    }
    public void deleteProfesor(long id){
        profesorRepository.deleteById(id);
    }

    public void modificarProfesor(Long idProfesor, String nombre, String apellido, String username, String contrasena){

        profesorRepository.modificarProfesor(idProfesor, nombre, apellido, username, contrasena);

    }

    public  List<Clase> getClasesVacias(){
        return profesorRepository.getClasesVacias();
    }

    public  List<Clase> getClasesProfesor(Long idProfesor){
        return profesorRepository.getClasesProfesor(idProfesor);
    }

    public void cambiarClase(Long idProfesor,Long idClaseCambiar,Long idClaseVacia){
        profesorRepository.cambiarClase(idProfesor,idClaseVacia);
        profesorRepository.quitarDeClase(idClaseCambiar);
    }


}
