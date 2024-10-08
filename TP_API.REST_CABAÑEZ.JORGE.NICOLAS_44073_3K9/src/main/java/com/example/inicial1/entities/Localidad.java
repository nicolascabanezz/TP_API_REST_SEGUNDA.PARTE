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

@Entity
@Table(name = "") //Por defecto: el nombre de la tabla será el nombre que tiene la clase
@Audited
public class Localidad extends Base{

    @Column(name = "")
    private String denominacion;

}
