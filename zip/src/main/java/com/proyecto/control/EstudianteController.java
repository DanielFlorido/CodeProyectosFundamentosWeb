package com.proyecto.control;

import com.proyecto.model.entity.Estudiante;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.annotation.WebFilter;
import java.util.List;

@Controller

public class EstudianteController {

@Autowired
    EstudianteService estudianteService;

    @GetMapping("/estudiantes")
    public String verEsudiantes(Model model){
        List<Estudiante> estudiantes = estudianteService.getEstudiantes();

        model.addAttribute("estudiantes",estudiantes);

        return "estudiantes";
    }

    @PostMapping("/agregarEstudiante")
    public String agregarEstudiante(@RequestParam("nombre")String nombre, @RequestParam("apellido")String apellido){
        estudianteService.addEstudiante(new Estudiante(nombre,apellido));
        return "redirect:/estudiantes";
    }
    @GetMapping("/addEstudiante")
    public String redireccionEstudiante(){
        return "agregarEstudiante";
    }


}

