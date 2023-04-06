package com.proyecto.control;

import com.proyecto.model.entity.Profesor;
import com.proyecto.model.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @PostMapping("/logIn")
    public String logIn(@RequestParam("username") String username, @RequestParam ("password") String password){
        List<Profesor> profesores = new ArrayList<Profesor>(profesorService.getProfesores());
        int i=0;
        while(i<profesores.size()){
            if(profesores.get(i).getPassword().equals(password)&&profesores.get(i).getUserName().equals(username))
                return "redirect:/exito.html";
        }
        //aqui va de front end :D y el que pasaria si no encuentra al profe
        return "algo";
    }
    
}
