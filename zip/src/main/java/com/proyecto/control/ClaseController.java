package com.proyecto.control;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.proyecto.model.entity.Asignatura;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.entity.Profesor;
import com.proyecto.model.entity.Semestre;
import com.proyecto.model.service.AsignaturaService;
import com.proyecto.model.service.ClaseService;
import com.proyecto.model.service.ProfesorService;
import com.proyecto.model.service.SemestreService;
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

    @Autowired
    AsignaturaService asignaturaService;

    @Autowired
    SemestreService semestreService;

    @Autowired
    ProfesorService profesorService;
    @GetMapping("/clases/{id}")
    public String verClases(@PathVariable long id,Model model, HttpSession session){
        // Recupera el profesor desde la sesión HTTP si existe entra, sino lo devuelve a login
        Optional<Profesor> optionalProfesor= Optional.ofNullable((Profesor) session.getAttribute("profesor"));
        if(optionalProfesor.isPresent()){
            Profesor profesor = optionalProfesor.get();
            List<Clase> clasesProfesor = claseService.getClasesPorProfesor(profesor,id);
            model.addAttribute("class", clasesProfesor);
            model.addAttribute("idAsignatura", id);
            return "clases";
        }
        return "redirect:/";
    }

    @GetMapping("/clasesAdmin")
    public String clasesAdmin(Model model){
        List<Asignatura> asignaturas = asignaturaService.getAsignaturas();
        List<Profesor> profesores = profesorService.getProfesores();

        model.addAttribute("asignaturas", asignaturas);
        model.addAttribute("profesores", profesores);

        return "clasesAdmin";
    }

    @PostMapping("/clasesAdmin")
    public String crearClase(@RequestParam("profesor") Long profesorId, @RequestParam("asignatura") Long asignaturaId, @RequestParam("idClase") int idClase, Model model) {
        // buscar el semestre usando el id del profesor
        Semestre semestre = semestreService.getSemestre(profesorId);
        // buscar la asignatura usando el id
        Asignatura asignatura = asignaturaService.getAsignatura(asignaturaId);


        // crear la nueva clase
        Clase clase = new Clase(semestre, asignatura, idClase);
        claseService.addClase(clase);

        // redirigir a la página de confirmación
        return "redirect:/clasesAdmin";
    }

    @GetMapping("/{clase}/asignaturas")
    public String clasesxasignaturaAdmin (@PathVariable long idAsignatura, Model model, HttpSession session){

        List<Clase> clases = claseService.getClases();

        model.addAttribute("clases", clases);

        return "clasesxasignaturaAdmin";
    }
}
