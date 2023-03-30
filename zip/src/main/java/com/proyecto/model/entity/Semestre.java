package com.proyecto.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity 
@Table(name="semestre")
@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class Semestre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name= "codSemestre")
    private String codSemestre;
    @ManyToOne
    private Profesor profesor;
    @OneToMany
    private List<Clase> clases;
    
    public Semestre(String codSemestre, Profesor profesor) {
        this.codSemestre = codSemestre;
        this.profesor = profesor;
    }
    
}
