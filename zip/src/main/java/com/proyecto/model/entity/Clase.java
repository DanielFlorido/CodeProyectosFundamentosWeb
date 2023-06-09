package com.proyecto.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clase")
@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class Clase {
    private int idClase;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;
    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;
    @ManyToMany(mappedBy = "clases", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes=new ArrayList<>();
    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL)
    private List<ListaNotas> notasClase= new ArrayList<>();
    public Clase(Semestre semestre, Asignatura asignatura,int idClase) {
        this.semestre = semestre;
        this.asignatura=asignatura;
        this.idClase=idClase;
    }

    public Clase(Clase clase, List<Estudiante> estudiantes,int idClase) {
        this.asignatura = clase.getAsignatura();
        this.semestre = clase.getSemestre();
        this.estudiantes = estudiantes;
        this.idClase=idClase;
    }

    public void addEstudiante(Estudiante estudiante){
        this.estudiantes.add(estudiante);
        estudiante.getClases().add(this);
    }
}
