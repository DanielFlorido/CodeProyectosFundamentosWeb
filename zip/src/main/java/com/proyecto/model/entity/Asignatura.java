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
@Table(name = "asignatura")
@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class Asignatura {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "idAsignatura")
    private int idAsignatura;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numCreditos")
    private int numCreditos;
    @Column(name = "syllabus")
    private String syllabus;
    @OneToMany(mappedBy = "asignatura")
    private List<Clase> clases;
    public Asignatura(int idAsignatura,String nombre, int numCreditos, String sylabus) {
        this.idAsignatura=idAsignatura;
        this.nombre = nombre;
        this.numCreditos = numCreditos;
        this.syllabus = sylabus;
        this.clases= new ArrayList<>();
    }
}
