package com.proyecto.control;
import com.proyecto.model.entity.Clase;
import com.proyecto.model.service.ClaseService;
import com.proyecto.model.service.ListaNotasService;
import com.proyecto.model.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Controller
public class NotaController {

    @Autowired
    NotaService notaService;

    @Autowired
    ListaNotasService listaNotaService;

    @Autowired
    ClaseService claseService;

    @GetMapping("/clases/{idAsignatura}/{idClase}")
    public String verNotasEstudiantes(@PathVariable long idAsignatura,@PathVariable int idClase, Model model, HttpSession session) throws SQLException {
        ArrayList<ArrayList<String>> tablaNotas = new ArrayList<ArrayList<String>>();
        Clase clase=claseService.getClase(idClase);
        //trae la descripcion de las ntoas de la clase
        List<String> descripciones = notaService.getDescripciones(idClase);
        model.addAttribute("descripciones", descripciones);

        //trae las notas de los estudiantes
        List<String> NotasEstudiantes = listaNotaService.getListaNotasPorClase(idClase);
        //cantidad de estudiantes en la clase

        int cantEstudiantes = clase.getEstudiantes().size();
        //separarNotasEstudiante
        ArrayList<String> NotasSeparadas = new ArrayList<>();
        String[] a;
        for(int i=0;i<NotasEstudiantes.size();i++){
            a=NotasEstudiantes.get(i).split(",");
            for(String separado : a){
                NotasSeparadas.add(separado);
            }
        }

        System.out.println("Notas separadas: ");
        System.out.println(NotasSeparadas);
        //llena la primear fila de la matriz
        ArrayList<ArrayList<Object>> matriz = new ArrayList<>();
        ArrayList<Object> miNuevoArrayList = new ArrayList<>();
        miNuevoArrayList.add("nombre");
        for(int i=0;i<descripciones.size();i++){
            miNuevoArrayList.add(descripciones.get(i));
        }
        matriz.add(miNuevoArrayList);

        //guardar las notas con su nombre
        Map<String, List<String>> notasPorEstudiante = new HashMap<>();
        for (int i = 0; i < NotasSeparadas.size(); i += 2) {
            String estudiante = NotasSeparadas.get(i);
            String nota = NotasSeparadas.get(i+1);

            // Si el estudiante ya está en el mapa, agregar la nota a su lista de notas
            if (notasPorEstudiante.containsKey(estudiante)) {
                notasPorEstudiante.get(estudiante).add(nota);
            } else {
                // Si el estudiante no está en el mapa, crear una nueva lista de notas con la nota actual
                List<String> notas = new ArrayList<>();
                notas.add(nota);
                notasPorEstudiante.put(estudiante, notas);
            }
        }

        for (Map.Entry<String, List<String>> entry : notasPorEstudiante.entrySet()) {
            ArrayList<Object> aux = new ArrayList<>();
            String estudiante = entry.getKey();
            aux.add(estudiante);
            List<String> notas = entry.getValue();
            for(int i=0;i<notas.size();i++){
                aux.add(notas.get(i));
            }
            matriz.add(aux);
        }
            model.addAttribute("notas",matriz);

        return "notasProfesor";
    }
    
}
