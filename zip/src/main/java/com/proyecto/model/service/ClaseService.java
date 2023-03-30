package com.proyecto.model.service;
import com.proyecto.model.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClaseService {
    @Autowired
    ClaseRepository claseRepository;
}
