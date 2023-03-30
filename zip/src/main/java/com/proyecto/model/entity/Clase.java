package com.proyecto.model.entity;

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
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne
    private Semestre semestre;

    @ManyToMany
    private List<Estudiante> estudiantes;
    public Clase(String nombre, Semestre semestre) {
        this.nombre = nombre;
        this.semestre = semestre;
    }
    
}
