package com.proyecto.util;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationRunner;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.repository.AsignaturaRepository;
import com.proyecto.model.repository.ClaseRepository;
import com.proyecto.model.repository.EstudianteRepository;
import com.proyecto.model.repository.ListaNotasRepository;
import com.proyecto.model.repository.NotaRepository;
import com.proyecto.model.repository.ProfesorRepository;
import com.proyecto.model.repository.SemestreRepository;

@Component
public class DataBaseInit implements ApplicationRunner {
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    ClaseRepository claseRepository;
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    ListaNotasRepository listaNotasRepository;
    @Autowired 
    ProfesorRepository profesorRepository;
    @Autowired 
    SemestreRepository semestreRepositoryl;
    @Autowired
    NotaRepository notaRepository;

    @Override @Transactional
    public void run(ApplicationArguments args) throws Exception {
        profesorRepository.save(new Profesor("pepe","123","Pepe","Repe"));
        profesorRepository.save(new Profesor("leo","123","Leonardo","Florez"));
        profesorRepository.save(new Profesor("andy" ,"123","Andrea","Rudea"));
        profesorRepository.save(new Profesor("hurty","123","Hurtado","Hernado"));
        profesorRepository.save(new Profesor("paluchi","123","Jaime","Pavlish"));
        profesorRepository.save(new Profesor("mari","123","mariela","cruel"));

    }
}
