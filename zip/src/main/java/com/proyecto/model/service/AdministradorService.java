package com.proyecto.model.service;

import com.proyecto.model.entity.Administrador;
import com.proyecto.model.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador getAdministrador(long id) {
        try {
            return administradorRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    public List<Administrador> getAdministrador() {
        return (List<Administrador>) administradorRepository.findAll();
    }

    public void addAdministrador(Administrador administrador) {
        administradorRepository.save(administrador);
    }


    public void deleteAdministrador(long id) {
        administradorRepository.deleteById(id);
    }
}