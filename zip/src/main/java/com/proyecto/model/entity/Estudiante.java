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
@Table(name = "estudiante")
@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class Estudiante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "estudiante_clase",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "clase_id"))
    private List<Clase> clases= new ArrayList<>();
    public Estudiante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
}
