package com.proyecto.control;

import com.proyecto.model.entity.Asignatura;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;


    @GetMapping("/profesores")
    public String verProfesor(Model model, HttpSession session) {
        // Recupera el profesor desde la sesión HTTP
        Optional<Profesor> optionalProfesor= Optional.ofNullable((Profesor) session.getAttribute("profesor"));
        if(optionalProfesor.isPresent()) {
            Profesor profesor = optionalProfesor.get();
            List<Asignatura> asignaturasProfesor = profesorService.getAsignaturasProfesor(profesor);
            ArrayList<String> asignaturasUnicas = new ArrayList<>();

            for (Asignatura a : asignaturasProfesor) {
                asignaturasUnicas.add(a.getIdAsignatura()+" "+a.getNombre());
            }

            // Agrega el profesor al modelo para que se puedan mostrar en la vista
            model.addAttribute("nombre", profesor.getNombre() + " " + profesor.getApellido());
            model.addAttribute("asignaturas", asignaturasUnicas);
            return "profesores";
        }
        return"redirect:/";
    }


    @PostMapping("/logIn")
    public String logIn(@RequestParam("username") String username, @RequestParam ("password") String password, HttpSession session){
        List<Profesor> profesores = new ArrayList<Profesor>(profesorService.getProfesores());
        int i=0;
        while(i<profesores.size()){
            Profesor profesor = profesores.get(i);
            if(profesores.get(i).getPassword().equals(password)&&profesores.get(i).getUserName().equals(username)){
                session.setAttribute("profesor", profesor);
                return "redirect:/profesores";
            }
            i++;
        }
        //aqui va de front end :D y el que pasaria si no encuentra al profe
        return "no encontrado";
    }


}
