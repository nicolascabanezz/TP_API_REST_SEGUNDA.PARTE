package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "domicilio")
@Audited
public class Domicilio extends Base{

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private int numero;

    //Relación con Localidad
    /*Indicamos que esta relación no es opcional. Es decir, que no puede ser nula. Siempre que cree una persona, el
    domicilio debe tener una localidad asociada.
    */
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;


}
