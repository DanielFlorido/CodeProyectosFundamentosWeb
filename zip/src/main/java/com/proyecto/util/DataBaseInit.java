package com.proyecto.util;

import javax.transaction.Transactional;

import com.proyecto.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationRunner;
import com.proyecto.model.repository.AsignaturaRepository;
import com.proyecto.model.repository.ClaseRepository;
import com.proyecto.model.repository.EstudianteRepository;
import com.proyecto.model.repository.ListaNotasRepository;
import com.proyecto.model.repository.NotaRepository;
import com.proyecto.model.repository.ProfesorRepository;
import com.proyecto.model.repository.SemestreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class DataBaseInit implements ApplicationRunner {
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    ClaseRepository claseRepository;
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    ListaNotasRepository listaNotasRepository;
    @Autowired 
    ProfesorRepository profesorRepository;
    @Autowired 
    SemestreRepository semestreRepository;
    @Autowired
    NotaRepository notaRepository;

    @Override @Transactional
    public void run(ApplicationArguments args) throws Exception {
        //Agregando profesores!!
        profesorRepository.save(new Profesor("ja.lopez", "12", "Javier", "Lopez"));
        profesorRepository.save(new Profesor("ju.carrenio", "12", "Julio", "Carrenio"));
        profesorRepository.save(new Profesor("ra.gonzales", "312", "Rafeael ", "Gonzales"));
        profesorRepository.save(new Profesor("ra.paez", "12", "Rafael", "Paez"));
        profesorRepository.save(new Profesor("en.gonzales", "12", "Enrique", "Gonzales"));
        profesorRepository.save(new Profesor("ef.ortiz", "12", "Efrain ", "Ortiz"));
        profesorRepository.save(new Profesor("ce.bustacara", "12", "Cesar", "Bustacara"));
        profesorRepository.save(new Profesor("an.carrillo", "12", "Angela", "Carrillo"));
        profesorRepository.save(new Profesor("al.pomares", "12", "Alexandra", "Pomares"));
        profesorRepository.save(new Profesor("ju.palacio", "12", "Julio", "Palacio"));
        profesorRepository.save(new Profesor("lu.diaz", "12", "Luis", "Diaz"));
        profesorRepository.save(new Profesor("ma.curiel", "12", "Mariela", "Curiel"));
        profesorRepository.save(new Profesor("le.florez", "12", "Leonardo", "Florez"));
        profesorRepository.save(new Profesor("ca.parra", "12", "Carlos", "Parra"));
        profesorRepository.save(new Profesor("jo.hurtado", "12", "Jose", "Hurtado"));
        profesorRepository.save(new Profesor("an.rueda", "12", "Andrea", "Rueda"));
        profesorRepository.save(new Profesor("ed.ruiz", "12", "Edgar ", "Ruiz"));
        profesorRepository.save(new Profesor("lu.moreno", "12", "Luis", "Moreno"));
        profesorRepository.save(new Profesor("jo.corredor", "12", "John", "Corredor"));
        profesorRepository.save(new Profesor("os.martinez", "12", "Oscar", "Martinez"));
        profesorRepository.save(new Profesor("ce.gauthier", "12", "Cecile", "Gauthier"));
        profesorRepository.save(new Profesor("ma.sanchez", "12", "Martha", "Sanchez"));
        profesorRepository.save(new Profesor("an.moreno", "12", "Andres", "Moreno"));
        profesorRepository.save(new Profesor("zs.varga", "12", "zsofia ", "Varga"));
        profesorRepository.save(new Profesor("ju.garavito", "12", "Juan", "Garavito"));
        profesorRepository.save(new Profesor("ma.umbarila", "12", "Maria", "Umbarila"));
        profesorRepository.save(new Profesor("ju.gil", "12", "Juan", "Gil"));
        profesorRepository.save(new Profesor("da.trujillo", "12", "Dalia", "Trujillo"));
        profesorRepository.save(new Profesor("ri.gonzalez", "12", "Ricardo", "Gonzalez"));
        //agregar asignaturas
        asignaturaRepository.save(new Asignatura(1295, "Calculo Diferencial", 3,"Calculo1"));
        asignaturaRepository.save(new Asignatura(1297, "Calculo Integral", 3,"Calculo2"));
        asignaturaRepository.save(new Asignatura(33732, "Probabilidad y estadistica", 3,"proba"));
        asignaturaRepository.save(new Asignatura(1299, "Calculo Vectorial", 3,"Calculo3"));
        asignaturaRepository.save(new Asignatura(1340, "Fisica Mecanica", 3,"Fisica1"));
        asignaturaRepository.save(new Asignatura(1290, "Algebra Lineal", 3,"Algebra"));
        asignaturaRepository.save(new Asignatura(33698, "introduccion a la programacion", 3,"Programacion1"));
        asignaturaRepository.save(new Asignatura(4075, "Pensamiento Sistemico", 3,"Sistemico"));
        asignaturaRepository.save(new Asignatura(33763, "introduccion a la ingenieria", 2,"intro inge"));
        asignaturaRepository.save(new Asignatura(34809, "Fundamentos seguridad de la informacion", 2,"Seguridad de la informacion"));
        asignaturaRepository.save(new Asignatura(33699, "Programacion Avanzada", 3,"Programacion2"));
        asignaturaRepository.save(new Asignatura(34816, "Gestion Financiera de Proyectos de Ti", 2,"Proyectos1"));
        asignaturaRepository.save(new Asignatura(33733, "Proyecto de Disenio en ingenieria", 2,"Proyectos2"));
        asignaturaRepository.save(new Asignatura(34580, "Arquitectura y organización del computador", 2,"Arqui del computador"));
        asignaturaRepository.save(new Asignatura(33700, "Bases de Datos", 4,"Bases"));
        asignaturaRepository.save(new Asignatura(34805, "Analisis y disenio de software", 3,"Analisis de software"));
        asignaturaRepository.save(new Asignatura(4190, "Comunicaciones y Redes", 4,"Redes"));
        asignaturaRepository.save(new Asignatura(2544, "Significacion teologica", 2,"Etica 1"));
        asignaturaRepository.save(new Asignatura(4196, "Estructuras de Datos", 3,"Estructuras"));
        asignaturaRepository.save(new Asignatura(4082, "Sistemas de informacion", 3,"Sisinfo"));
        asignaturaRepository.save(new Asignatura(34803, "Gestion de proyectos de inocacion y emporendimiento de TI", 3,"Proyectos3"));
        asignaturaRepository.save(new Asignatura(34806, "Fundamentos de ingenieria de Software", 3,"ingesoft"));
        asignaturaRepository.save(new Asignatura(4085, "Sistemas Operativos", 3,"operativos"));
        asignaturaRepository.save(new Asignatura(34801, "Teoria de la computacion", 2,"teoria"));
        asignaturaRepository.save(new Asignatura(34810, "Proyecto de innovacion y emprendimiento", 3,"Proyectos4"));
        asignaturaRepository.save(new Asignatura(22586, "introduccion a sistemas distribuidos", 2,"distribuidos"));
        asignaturaRepository.save(new Asignatura(1300, "Ecuaciones Diferenciales", 3,"Calculo4"));
        asignaturaRepository.save(new Asignatura(34866, "Optimizacion y simulacion", 2,"Opti"));
        asignaturaRepository.save(new Asignatura(3194, "Analisis de algoritmos", 2,"Analisis de algortimos"));
        asignaturaRepository.save(new Asignatura(34807, "Desarrollo Web", 3,"web"));
        asignaturaRepository.save(new Asignatura(34808, "Introduccion a la computacion movil", 2,"Compumovil"));
        asignaturaRepository.save(new Asignatura(2476, "Fe y compromiso del ingeniero", 2,"Etica2"));
        asignaturaRepository.save(new Asignatura(1291, "Analisis numerico", 3,"Calculo5"));
        asignaturaRepository.save(new Asignatura(4084, "introduccion Inteligencia artificial", 3,"IA"));
        asignaturaRepository.save(new Asignatura(31339, "Planeacion de Proyecto Final", 2,"Planeacion"));
        asignaturaRepository.save(new Asignatura(4185, "Arquitectura de software", 3,"Arquitectura"));
        asignaturaRepository.save(new Asignatura(5100, "Proyecto Social Universitario", 3,"Proyecto"));
        asignaturaRepository.save(new Asignatura(34863, "Etica en la era de la informacion", 2,"Etica3"));
        asignaturaRepository.save(new Asignatura(34802, "Tecnologias digitales emergentes", 2,"emergentes"));
        asignaturaRepository.save(new Asignatura(34814, "Proyecto de grado", 3,"Proyecto de grado"));
        asignaturaRepository.save(new Asignatura(34804, "Gerencia Estrategica de TI", 2,"Proyecto5"));
        asignaturaRepository.save(new Asignatura(16143, "Constitucion y Derecho Civil", 2,"constitucion"));
        asignaturaRepository.save(new Asignatura(2356, "Epistemologia de la ingenieria", 2,"Filosofia1"));
        //agregar semestres!
        for(Profesor profe: profesorRepository.findAll()){
            semestreRepository.save(new Semestre("2023-1",profe));
        }
        //agregar Clase al profesor 27 para mas facilidad :D en concreto da 3 clases de la asignatura 20
        claseRepository.save(new Clase( semestreRepository.findById((long) 27).get(),asignaturaRepository.findById((long)20).get()));
        claseRepository.save(new Clase( semestreRepository.findById((long) 27).get(),asignaturaRepository.findById((long)20).get()));
        claseRepository.save(new Clase( semestreRepository.findById((long) 27).get(),asignaturaRepository.findById((long)20).get()));

        estudianteRepository.save(new Estudiante("Ana", "García"));
        estudianteRepository.save(new Estudiante("David", "López"));
        estudianteRepository.save(new Estudiante("Maria", "Perez"));
        estudianteRepository.save(new Estudiante("Jorge", "Rodriguez"));
        estudianteRepository.save(new Estudiante("Laura", "Sanchez"));
        estudianteRepository.save(new Estudiante("Luis", "Martinez"));
        estudianteRepository.save(new Estudiante("Sara", "Fernandez"));
        estudianteRepository.save(new Estudiante("Javier", "Gomez"));
        estudianteRepository.save(new Estudiante("Alicia", "Ramirez"));
        estudianteRepository.save(new Estudiante("Carlos", "Hernandez"));
        estudianteRepository.save(new Estudiante("Elena", "Torres"));
        estudianteRepository.save(new Estudiante("Miguel", "González"));
        estudianteRepository.save(new Estudiante("Marta", "Ruiz"));
        estudianteRepository.save(new Estudiante("Juan", "Castro"));
        estudianteRepository.save(new Estudiante("Patricia", "Díaz"));
        estudianteRepository.save(new Estudiante("Josefa", "Torres"));
        estudianteRepository.save(new Estudiante("Antonio", "Moreno"));
        estudianteRepository.save(new Estudiante("Susana", "Aguilar"));
        estudianteRepository.save(new Estudiante("Diego", "Castillo"));
        estudianteRepository.save(new Estudiante("Gloria", "García"));
        estudianteRepository.save(new Estudiante("Ricardo", "Vargas"));
        estudianteRepository.save(new Estudiante("Belen", "Alvarado"));
        estudianteRepository.save(new Estudiante("Fernando", "Sánchez"));
        estudianteRepository.save(new Estudiante("Pilar", "Ruiz"));
        estudianteRepository.save(new Estudiante("Rafael", "Muñoz"));
        estudianteRepository.save(new Estudiante("Sandra", "Jiménez"));
        estudianteRepository.save(new Estudiante("Omar", "Hernández"));
        estudianteRepository.save(new Estudiante("Adriana", "Flores"));
        estudianteRepository.save(new Estudiante("Gustavo", "Ramos"));
        estudianteRepository.save(new Estudiante("Lorena", "Álvarez"));
        estudianteRepository.save(new Estudiante("Angelica", "Medina"));
        estudianteRepository.save(new Estudiante("Sebastian", "Castro"));
        estudianteRepository.save(new Estudiante("Ivonne", "Rios"));
        estudianteRepository.save(new Estudiante("Cristobal", "Mendoza"));
        estudianteRepository.save(new Estudiante("Vanessa", "Vargas"));
        estudianteRepository.save(new Estudiante("Oscar", "Solis"));
        estudianteRepository.save(new Estudiante("Lorena", "Flores"));
        estudianteRepository.save(new Estudiante("Felipe", "Sandoval"));
        estudianteRepository.save(new Estudiante("Marina", "Garza"));
        estudianteRepository.save(new Estudiante("Mario", "Guerrero"));
        estudianteRepository.save(new Estudiante("Fabiola", "Gomez"));
        estudianteRepository.save(new Estudiante("Guillermo", "Gallegos"));
        estudianteRepository.save(new Estudiante("Brenda", "Torres"));
        estudianteRepository.save(new Estudiante("Rodolfo", "Sanchez"));
        estudianteRepository.save(new Estudiante("Gloria", "Torres"));
        estudianteRepository.save(new Estudiante("Francisco", "Rivera"));
        estudianteRepository.save(new Estudiante("Rosalba", "Ramirez"));
        estudianteRepository.save(new Estudiante("Gerardo", "Castillo"));
        estudianteRepository.save(new Estudiante("Norma", "Valdez"));
        estudianteRepository.save(new Estudiante("Leonardo", "Castro"));
        estudianteRepository.save(new Estudiante("Valerea", "Rivas"));
        estudianteRepository.save(new Estudiante("Sergio", "Montoya"));
        estudianteRepository.save(new Estudiante("Ana", "Torres"));
        estudianteRepository.save(new Estudiante("Manuel", "Chavez"));
        estudianteRepository.save(new Estudiante("Paola", "Salazar"));
        estudianteRepository.save(new Estudiante("Roberto", "Aguilar"));
        estudianteRepository.save(new Estudiante("Karla", "Vazquez"));
        estudianteRepository.save(new Estudiante("Rene", "Castillo"));
        estudianteRepository.save(new Estudiante("Isabela", "Guitierrez"));
        estudianteRepository.save(new Estudiante("Arturo", "Hernandez"));

        for(int i=1;i<=3;i++){
            Clase clase = claseRepository.findById((long)i).get();
            for(int j=1*(20*(i-1));j<20*i;j++){
                try{
                    Estudiante estudiante = estudianteRepository.findById((long)j).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
                    clase.addEstudiante(estudiante);
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
            claseRepository.save(clase);
        }
        Clase claseaux=claseRepository.findById((long)1).get();
        for(int i=0; i<claseaux.getEstudiantes().size();i++){
            listaNotasRepository.save(new ListaNotas(claseaux.getEstudiantes().get(i),claseaux));
        }
        //todos sacaron 2 D:
        for(ListaNotas l: listaNotasRepository.findAll()){
            l.addNota(new Nota(2,(float)0.25,"parcial",l));
        }
        System.out.println("__♥__♥_____♥__♥___ Put This");
        System.out.println("_♥_____♥_♥_____♥__ Heart");
        System.out.println("_♥______♥______♥__ On Your");
        System.out.println("__♥_____/______♥__ Page If");
        System.out.println("___♥____\\_____♥___ You Had");
        System.out.println("____♥___/___♥_____ Your Heart");
        System.out.println("______♥_\\_♥_______ Broken");
        System.out.println("________♥_________. ");
    }

}
