package com.proyecto.control;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ClaseController {

    @Autowired
    ClaseService claseService;

    @GetMapping("/clases/{nombreAsignatura}")
    public String verClases(@PathVariable("nombreAsignatura") String nombreAsignatura,Model model, HttpSession session){
        System.out.println(nombreAsignatura);

        return "clases";
    }
    
}
