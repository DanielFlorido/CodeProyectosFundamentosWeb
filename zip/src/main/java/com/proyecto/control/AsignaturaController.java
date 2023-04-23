package com.proyecto.control;
import com.proyecto.model.entity.Asignatura;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AsignaturaController {

    @Autowired
    AsignaturaService asignaturaService;
    @GetMapping("/{nombreProfesor}/asignaturas")
    public String verProfesor(@PathVariable("nombreProfesor") String nombreProfesor, Model model, HttpSession session) {
        // Recupera el profesor desde la sesión HTTP si existe entra, sino lo devuelve a login
        Optional<Profesor> optionalProfesor= Optional.ofNullable((Profesor) session.getAttribute("profesor"));
        if(optionalProfesor.isPresent()) {
            Profesor profesor = optionalProfesor.get();
            //revisa si el nombre del profesor de la sesion es el mismo que el que recibimos en el url
            if(nombreProfesor.equalsIgnoreCase(profesor.getNombre())) {
                List<Asignatura> asignaturasProfesor = asignaturaService.getAsignaturasPorProfesor(profesor);
                // Agrega el profesor al modelo para que se puedan mostrar en la vista
                model.addAttribute("nombre", profesor.getNombre() + " " + profesor.getApellido());
                model.addAttribute("asignaturas", asignaturasProfesor);
                return "asignaturas";
            }else{
                return"redirect:/";
            }
        }
        return "redirect:/";
    }
    @GetMapping("/asignaturas")
    public String verAsignaturas(Model model){
        List<Asignatura> asignaturas = asignaturaService.getAsignaturas();

        model.addAttribute("asignaturas", asignaturas);

        return "asignaturas";
    }



}
