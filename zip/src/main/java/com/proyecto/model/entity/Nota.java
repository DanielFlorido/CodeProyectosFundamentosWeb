package com.proyecto.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nota")
    private float nota;
    @Column(name = "porcentaje")
    private float porcentaje;
    @Column(name = "descripcion")
    private String descripcion;
    public Nota(float nota, float porcentaje, String descripcion) {
        this.nota = nota;
        this.porcentaje = porcentaje;
        this.descripcion = descripcion;
    }
    
}
