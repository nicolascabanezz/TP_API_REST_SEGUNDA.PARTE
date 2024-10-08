package com.example.inicial1.repositories;


import com.example.inicial1.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {

}

/*
- BaseRepository será la base para todos los repositorios de nuestras entidades.
- Como no vamos a necesitar que este repositorio se instancie, vamos a utilizar la etiqueta @NoRepositoryBean. (Desde
esta interface no se pueden crear instancias.)
- Este repositorio recibe dos tipos de datos, el primero será el tipo de la entidad, al que llamaremos E (el mismo
extiende de Base, para que no se puedan utilizar tipos de datos que no extiendan de Base.). El segundo tipo de dato que
recibe es el ID, que es el tipo de ID que tiene la entidad. ID debe extender de Serializable.
- BaseRepository extiende de JpaRepository y también recibe los tipos de datos E y ID.
*/