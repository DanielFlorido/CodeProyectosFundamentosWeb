package com.proyecto.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name ="administrador")
@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor

public class Administrador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="userName")
    private String userName;
    @Column(name= "password")
    private String password;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @OneToMany(mappedBy = "administrador")
    @Fetch(FetchMode.JOIN)
    private List<Profesor> profesors= new ArrayList<>();
    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "administrador")
    private List<Estudiante> estudiantes= new ArrayList<>();

    public Administrador(String userName, String password, String nombre, String apellido) {
        this.userName = userName;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesors= new ArrayList<>();
        this.estudiantes= new ArrayList<>();
    }
    public void addProfesor(Profesor profesors){
        this.profesors.add(profesors);
    }
    public void addEstudiante(Estudiante estudiantes){
        this.estudiantes.add(estudiantes);
    }

}