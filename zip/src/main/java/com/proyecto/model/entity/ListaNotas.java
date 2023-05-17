package com.proyecto.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "listaNotas")
@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class  ListaNotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "notaFinal")
    private float notaFinal;
    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    @OneToMany(mappedBy = "listaNotas",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Nota> notas= new ArrayList<>();
    
    public ListaNotas(Estudiante estudiante, Clase clase) {
        this.notaFinal = 0;
        this.estudiante = estudiante;
        this.clase = clase;
    }

    public void addNota(Nota nota){
        this.notas.add(nota);
    }


}
