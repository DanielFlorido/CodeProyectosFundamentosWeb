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

@Controller
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;


    @GetMapping("/profesores")
    public String verProfesor(Model model, HttpSession session) {
        // Recupera el profesor desde la sesión HTTP
        Profesor profesor = (Profesor) session.getAttribute("profesor");
        HashSet<Asignatura> asignaturas = new HashSet<>();
        ArrayList<String> asignaturasUnicas = new ArrayList<>();

        //Este for se encarga de sacar las asignaturas que tiene el profesor en un arraylist
        for(int i=0;i<profesor.getSemestres().get(0).getClases().size();i++){
            Asignatura asignatura= profesor.getSemestres().get(0).getClases().get(i).getAsignatura();
            if(asignaturas.add(asignatura)){
                asignaturasUnicas.add(asignatura.getNombre()+" "+asignatura.getIdAsignatura());
            }
        }

        // Agrega el profesor al modelo para que se puedan mostrar en la vista
        model.addAttribute("nombre", profesor.getNombre()+" "+profesor.getApellido());
        model.addAttribute("asignaturas",asignaturasUnicas);
        return "profesores";
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
