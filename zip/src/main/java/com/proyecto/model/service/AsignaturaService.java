package com.proyecto.model.service;
import com.proyecto.model.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {
    @Autowired
    AsignaturaRepository asignaturaRepository;
}
