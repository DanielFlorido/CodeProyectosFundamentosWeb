package com.proyecto.model.service;

import com.proyecto.model.entity.Semestre;
import com.proyecto.model.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SemestreService {
    @Autowired
    private SemestreRepository semestreRepository;

    public Semestre getSemestre(long id){
        try{
            return semestreRepository.findById(id).orElseThrow();
        }catch (NoSuchElementException e){
            return null;
        }
    }
    public List<Semestre> getSemestres(){
        return (List<Semestre>) semestreRepository.findAll();
    }

    public void addSemestre(Semestre pSemestre){
        semestreRepository.save(pSemestre);
    }

    public void deleteSemestre(long id){
        semestreRepository.deleteById(id);
    }
}
