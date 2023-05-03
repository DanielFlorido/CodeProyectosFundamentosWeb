package com.proyecto.control;



import com.proyecto.model.entity.Administrador;
import com.proyecto.model.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdministradorController {
    @Autowired
    AdministradorService administradorService;
    @PostMapping("/logInAdmin")
    public String logIn(@RequestParam("username") String username, @RequestParam ("password") String password, HttpSession session){
        List<Administrador> administrador= new ArrayList<Administrador>(administradorService.getAdministradores());
        int i=0;
        while(i<administrador.size()){
            Administrador administrador1 = administrador.get(i);
            if(administrador.get(i).getPassword().equals(password)&&administrador.get(i).getUserName().equals(username)){
                session.setAttribute("administrador", administrador);
                return "administrador";
            }
            i++;
        }

        return "no encontrado";
    }
    @GetMapping("/loginAdmin")
    public String redireccion(){

        return "loginAdmin";
    }
    
}
