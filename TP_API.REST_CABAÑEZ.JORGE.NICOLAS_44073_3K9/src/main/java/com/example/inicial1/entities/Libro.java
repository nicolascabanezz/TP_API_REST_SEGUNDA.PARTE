package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "libro")
@Audited
public class Libro extends Base{

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha")
    private int fecha; //Pq fecha int?

    @Column(name = "")
    private String genero;

    @Column(name = "")
    private int paginas;

    //Relación con Autor
    /*
    CascadeType.REFRESH: nos aseguramos que al momento de persistir un libro, siempre se mantendrán actualizados los
    autores, es decir, que si ocurre un cambio en un autor también se actualizará libro.
    */
    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;



}
