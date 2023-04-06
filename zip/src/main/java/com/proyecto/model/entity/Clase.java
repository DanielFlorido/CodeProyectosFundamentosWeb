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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;
    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;
    @ManyToMany(mappedBy = "clases")
    private List<Estudiante> estudiantes;
    @OneToMany(mappedBy = "clase")
    private List<ListaNotas> notasClase;
    public Clase(Semestre semestre, Asignatura asignatura) {
        this.semestre = semestre;
        this.asignatura=asignatura;
        this.estudiantes= new ArrayList<>();
        this.notasClase=new ArrayList<>();
    }

    public Clase(Clase clase, List<Estudiante> estudiantes) {
        this.asignatura = clase.getAsignatura();
        this.semestre = clase.getSemestre();
        this.estudiantes = estudiantes;
    }

    public void addEstudiante(Estudiante estudiante){
        this.estudiantes.add(estudiante);
    }
}
