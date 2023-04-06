package com.proyecto.model.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nota")
@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nota")
    private float nota;
    @Column(name = "porcentaje")
    private float porcentaje;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "listaNotas_id")
    private ListaNotas listaNotas;
    public Nota(float nota, float porcentaje, String descripcion) {
        this.nota = nota;
        this.porcentaje = porcentaje;
        this.descripcion = descripcion;
    }
    
}
