package com.proyecto.model.service;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.ListaNotas;
import com.proyecto.model.repository.ListaNotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class ListaNotasService {
    @Autowired
    ListaNotasRepository listaNotasRepository;

    public ListaNotas getListaNotas(long id){
        try{
            return listaNotasRepository.findById(id).orElseThrow();
        }catch (NoSuchElementException e){
            return null;
        }
    }
    public List<ListaNotas> getListaNotas(){
        return (List<ListaNotas>) listaNotasRepository.findAll();
    }

    public void addListaNotas(ListaNotas pListaNotas){
        listaNotasRepository.save(pListaNotas);
    }
    public void deleteListaNotas(long id){
        listaNotasRepository.deleteById(id);
    }

    public List<String> getListaNotasPorClase(int idClase){
        return listaNotasRepository.getListaNotasPorClase(idClase);
    }

    public int cantidadEstudiantes(int idClase){
        return listaNotasRepository.cantidadEstudiantes(idClase);
    }



}
