package com.proyecto.control;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ClaseController {
    @Autowired
    ClaseService claseService;

    @GetMapping("/clases/{id}")
    public String verClases(@PathVariable long id,Model model, HttpSession session){
        // Recupera el profesor desde la sesión HTTP si existe entra, sino lo devuelve a login
        Optional<Profesor> optionalProfesor= Optional.ofNullable((Profesor) session.getAttribute("profesor"));
        if(optionalProfesor.isPresent()){
            Profesor profesor = optionalProfesor.get();
            List<Clase> clasesProfesor = claseService.getClasesPorProfesor(profesor,id);
            model.addAttribute("class", clasesProfesor);
            return "clases";
        }
        return "redirect:/";
    }

}
