package com.proyecto.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "listanotas")
@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class ListaNotas {    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "notaFinal")
    private float notaFinal;
    @OneToOne
    private Estudiante estudiante;
    @OneToMany
    private List<Nota> notas;
    
    public ListaNotas(float notaFinal, Estudiante estudiante) {
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
    }
}
