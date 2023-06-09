package com.proyecto.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @JoinColumn(name = "profesor_id",nullable = true)
    private Profesor profesor;
    @OneToMany(mappedBy = "semestre")
    @Fetch(FetchMode.JOIN)
    private List<Clase> clases= new ArrayList<>();
    
    public Semestre(String codSemestre, Profesor profesor) {
        this.codSemestre = codSemestre;
        this.profesor = profesor;
    }

    public void addClase(Clase clase){
        this.clases.add(clase);
    }
    
}
