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

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name ="profesor")
@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class Profesor {
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
    @OneToMany(mappedBy = "profesor")
    private List<Semestre> semestres;
    
    public Profesor(String userName, String password, String nombre, String apellido) {
        this.userName = userName;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestres= new ArrayList<>();
    }
    public void addSemestre(Semestre semestre){
        this.semestres.add(semestre);
    }

}

