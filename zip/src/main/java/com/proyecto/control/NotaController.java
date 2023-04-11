package com.proyecto.control;
import com.proyecto.model.service.ClaseService;
import com.proyecto.model.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class NotaController {

    @Autowired
    NotaService notaService;


    @GetMapping("/clases/{idAsignatura}/{idClase}")
    public String verNotasEstudiantes(@PathVariable long idAsignatura,@PathVariable int idClase, Model model, HttpSession session){

        return "notas";
    }
    
}
