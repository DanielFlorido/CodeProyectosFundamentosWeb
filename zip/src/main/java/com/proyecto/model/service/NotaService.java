package com.proyecto.model.service;
import com.proyecto.model.entity.Nota;
import com.proyecto.model.repository.NotaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NotaService {
    @Autowired
    NotaRepository notaRepository;

    public Nota getNota(long id){
        try{
            return notaRepository.findById(id).orElseThrow();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public List<Nota> getNotas(){
        return (List<Nota>) notaRepository.findAll();
    }

    public void addNota(Nota pNota){
        notaRepository.save(pNota);
    }

    public void deleteNota(long id){
        notaRepository.deleteById(id);
    }

    public List<String> getDescripciones(int idClase){
        return notaRepository.getDescripciones(idClase);
    }

}
