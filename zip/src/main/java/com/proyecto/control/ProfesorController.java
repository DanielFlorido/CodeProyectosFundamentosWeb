package com.proyecto.control;

import com.proyecto.model.entity.*;
import com.proyecto.model.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @PostMapping("/logIn")
    public String logIn(@RequestParam("username") String username, @RequestParam ("password") String password, HttpSession session,Model model){
        List<Profesor> profesores = new ArrayList<Profesor>(profesorService.getProfesores());
        int i=0;
        while(i<profesores.size()){
            Profesor profesor = profesores.get(i);
            if(profesores.get(i).getPassword().equals(password)&&profesores.get(i).getUserName().equals(username)){
                session.setAttribute("profesor", profesor);
                return "redirect:/asignaturas/"+profesor.getNombre();
            }
            i++;
        }
        //aqui va de front end :D y el que pasaria si no encuentra al profe
        model.addAttribute("error","Usuario o contraseña incorrectos");
        return "index";
    }

    @GetMapping("/profesores")
    public String verProfesores(Model model){
        List<Profesor> profesores = profesorService.getProfesores();

        model.addAttribute("profesores",profesores);

        return "profesores";
    }
    @PostMapping("/agregarProfesor")
    public String agregarProfesor(@RequestParam ("username") String username, @RequestParam("password")String password, @RequestParam("nombre")String nombre, @RequestParam("apellido")String apellido){
       profesorService.addProfesor(new Profesor(username,password,nombre,apellido));
       return "redirect:/profesores";
    }
    @GetMapping("/addProfesor")
    public String redireccionProfesor(){
        return "agregarProfesor";
    }
    @GetMapping("/profesores/eliminarProfesor/{idProfesor}")
    public String eliminarProfesor(@PathVariable("idProfesor") Long idProfesor){
        //Se obtiene la lista de semestres del profesor a eliminar
        List<Semestre> semestres = profesorService.getProfesor(idProfesor).getSemestres();

        //Se asigna nulo a todos los semestres de ese profesor
        for(int i=0;i<semestres.size();i++){
            semestres.get(i).setProfesor(null);
        }

        //se elimina el profesor de la base de datos
        profesorService.deleteProfesor(idProfesor);

        return "redirect:/profesores";
    }

    @GetMapping("/profesores/modificarProfesor/{idProfesor}")
    public String redireccionarModificar(@PathVariable("idProfesor") Long idProfesor, Model model){

        Profesor profesor = profesorService.getProfesor(idProfesor);

        model.addAttribute("nombreProfesor",profesor.getNombre()+" "+profesor.getApellido());

        return "modificarProfesor";
    }

    @Transactional
    @PostMapping("/profesores/modificarProfesor/{idProfesor}")
    public String modificarProfesor(@PathVariable("idProfesor") Long idProfesor,@RequestParam ("username") String username, @RequestParam("password")String password, @RequestParam("nombre")String nombre, @RequestParam("apellido")String apellido){

        profesorService.modificarProfesor(idProfesor,nombre,apellido,username,password);

        return "redirect:/profesores";
    }

    @GetMapping("/profesores/cambiarProfesorClase/{idProfesor}")
    public String redireccionarCambiarClase(@PathVariable("idProfesor") Long idProfesor, Model model) {

        Profesor profesor = profesorService.getProfesor(idProfesor);

        //clases del profesor
        List<Clase> clasesProfe = profesorService.getClasesProfesor(idProfesor);
        model.addAttribute("clasesProfe",clasesProfe);

        //clases que no tengan profesor
        List<Clase> clasesVacias = profesorService.getClasesVacias();
        model.addAttribute("clasesVacias",clasesVacias);

        model.addAttribute("nombreProfesor",profesor.getNombre()+" "+profesor.getApellido());



        return "cambiarProfesorClase";
    }

    @Transactional
    @PostMapping("/profesores/cambiarProfesorClase/{idProfesor}")
    public String cambiarClase(@PathVariable("idProfesor") Long idProfesor,@RequestParam ("claseProfe") Long claseACambiar, @RequestParam("claseVacia") Long claseCambio){

        profesorService.cambiarClase(idProfesor,claseACambiar,claseCambio);


        return "redirect:/profesores";
    }



}

