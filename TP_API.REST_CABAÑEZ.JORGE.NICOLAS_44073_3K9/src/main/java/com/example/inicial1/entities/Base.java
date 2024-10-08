package com.example.inicial1.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}

/*
- Esta clase tendrá los métodos y atributos que sean comunes para todas las clases.
- Las clases que quieren heredas dichos métodos y atributos, deberán extender de esta clase.
- La clase Base implementa Serializable. De esta forma, todas las entidades que hereden de Base también implementarán
Serializable. (Nos ahorramos que las clases hijas también implementen Serializable).
- id es el atributo que tienen en común todas las entidades de nuestro modelo.
*/