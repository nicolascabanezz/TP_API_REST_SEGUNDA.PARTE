package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Anotaciones de Lombok
@AllArgsConstructor
@NoArgsConstructor //Constructor vacío
@Setter
@Getter
@Audited //Para la auditoría
@ToString
@Builder

@Entity
@Table(name = "persona")
public class Persona extends Base {
    /*
    Como Persona extiende de Base ya no necesitamos declarar el id ni tampoco implementar Serializable.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    */
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private int dni;

    //Relación con Domicilio
    //CascadeType.ALL nos permitirá hacer la persistencia, actualización y eliminación a través de la misma persona.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    //Relación con Libro
    //orphanRemoval = true a la hora de eliminar una persona, se eliminarán todos los libros que le pertenecen
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "persona_libro",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro> libros = new ArrayList<Libro>();

}

