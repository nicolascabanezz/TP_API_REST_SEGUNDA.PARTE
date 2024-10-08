package com.example.inicial1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited

@Entity
@Table(name = "autor")
public class Autor extends Base{
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "biografia", length = 1500) //Establecemos un string de máximo 1500 caracteres.
    private String biografia;


}

/*
- Esta clase también extienen de Base. Es decir, que hereda el atributo id y también implementa Serializable.
- Recordar que si no colocamos la etiqueta @Column y no declaramos un nombre específico, la columna de la tabla tendrá
el nombre del atributo.
*/