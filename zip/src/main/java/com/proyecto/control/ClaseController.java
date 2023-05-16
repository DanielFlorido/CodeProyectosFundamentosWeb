package com.proyecto.control;
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
import javax.transaction.Transactional;
import java.beans.Transient;
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
    public String ClasesProfesorAsignatura(@PathVariable long id, Model model, HttpSession session){
        // Recupera el profesor desde la sesión HTTP si existe entra, sino lo devuelve a login
        Optional<Profesor> optionalProfesor= Optional.ofNullable((Profesor) session.getAttribute("profesor"));
        if(optionalProfesor.isPresent()){
            Profesor profesor = optionalProfesor.get();
            List<Clase> clasesProfesor = claseService.getClasesPorProfesor(profesor,id);
            model.addAttribute("class", clasesProfesor);
            model.addAttribute("idAsignatura", id);
            return "clasesProfesor";
        }
        return "redirect:/";
    }
    @GetMapping("/addClase")
    public String redireccionClase(Model model){
        List<Asignatura> asignaturas = asignaturaService.getAsignaturas();
        List<Profesor> profesores = profesorService.getProfesores();

        model.addAttribute("asignaturas", asignaturas);
        model.addAttribute("profesores", profesores);

        return "agregarClase";
    }

    @PostMapping("/agregarClase")
    public String crearClase(@RequestParam("profesor") Long profesorId, @RequestParam("asignatura") Long asignaturaId, @RequestParam("idClase") int idClase, Model model) {
        // buscar el semestre usando el id del profesor
        Semestre semestre = semestreService.getSemestre(profesorId);
        // buscar la asignatura usando el id
        Asignatura asignatura = asignaturaService.getAsignatura(asignaturaId);


        // crear la nueva clase
        Clase clase = new Clase(semestre, asignatura, idClase);
        claseService.addClase(clase);

        // redirigir a la página de confirmación
        return "redirect:/clases";
    }
    @GetMapping("/asignaturas/{clase}/AquivaAlgomas")
    public String clasesxasignaturaAdmin (@PathVariable("clase") long idAsignatura, Model model, HttpSession session){

        List<Clase> clases = claseService.getClases();

        model.addAttribute("clases", clases);

        return "clasesxasignaturaAdmin";
    }
    @GetMapping("/clases")
    public String verClases(Model model) {
        List<Clase> clases = claseService.getClases();
        model.addAttribute("clases", clases);
        return "clases";
    }
    @GetMapping("/clases/eliminarClase/{idClase}")
    public String eliminarClase(@PathVariable("idClase")Long idClase){
        claseService.deleteClase(idClase);
        return "redirect: /clases";
    }
    @GetMapping("/clases/modificarClase/{idProfesor}")
    public String redireccionarModificar(@PathVariable("idClase") Long idClase, Model model){
        Clase clase = claseService.getClase(idClase);

        model.addAttribute("ID de la Clase y de la Asignatura", clase.getIdClase()+" "+clase.getAsignatura());

        return "modificarClase";
    }
    @Transactional
    @PostMapping("/clase/modificarClase/{idClase}")
    public String modificarClase (@PathVariable("idClase") Long idClase, @RequestParam ("idAsignatura") long idAsignatura){

        claseService.modificarClase(idClase, idAsignatura);

        return "redirect:/clases";

    }

}
