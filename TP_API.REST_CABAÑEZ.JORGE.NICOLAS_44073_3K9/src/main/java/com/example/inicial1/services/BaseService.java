package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

// Esta interface es genérica. Es decir, que puede recibir como parámetro algún tipo de entidad.
public interface BaseService <E extends Base, ID extends Serializable> {

    // Creamos lo métodos que necesitamos
    public List <E> findAll() throws Exception; //Nos trae una lista de todos los objetos de la BD
    public E findById(ID id) throws Exception; //Nos trae un objeto de acuerdo a su id
    public E save(E entity) throws Exception; //Crea una nueva entidad
    public E update(ID id, E entity) throws Exception; //Actualiza un objeto de la BD
    public boolean delete(ID id) throws Exception; //Deletea un objeto de la BD

    //METODO QUE NOS PERMITIRÁ DEVOLVER LOS DATOS PAGINAS
    public Page<E> findAll(Pageable pageable) throws Exception;


}
 /*
 Posteriormente, podemos implementar esta interface en todos los servicios que necesitemos sin la necesidad de
 declarar uno por uno los métodos.
  */