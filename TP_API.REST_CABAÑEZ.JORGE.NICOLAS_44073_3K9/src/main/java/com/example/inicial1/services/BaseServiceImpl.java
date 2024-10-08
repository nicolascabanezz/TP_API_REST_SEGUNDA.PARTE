package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    //Llamamos una instancia de nuestro repositorio base
    protected BaseRepository<E, ID> baseRepository; //Lo hacemos protected para que lo puedan utilizar las clses que heredan de BaseService.

    //Constructor
    public BaseServiceImpl(BaseRepository<E, ID> baseRepository){
        this.baseRepository = baseRepository;
    }

    //Implementamos los métodos de la interface

    @Override
    @Transactional //Indica que el metodo hace transacciones con la BD
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll(); //Obtiene de la BD todas las personas registradas
            return entities; //Retorna las personas obtenidas
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Implementamos el metodo para la paginacion
    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception{
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            //Utilizamos Optional pq no podemos asegurar que existe un objeto con ese id como PK
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.get(); //Retorna el objeto encontrado, si no excepcion.
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            //Utilizamos findById para obtener la persona que queremos actualizar
            Optional<E> entityOptional = baseRepository.findById(id);
            E entityUpdate = entityOptional.get();
            entityUpdate = baseRepository.save(entity); //Actualizamos persona
            return entityUpdate; //Retornamos persona actualizada
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            //Utilizamos if para saber si existe algún objeto persona con el id indicado
            if (baseRepository.existsById(id)){
                baseRepository.deleteById(id); //Si existe, borramos la persona
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}

/*
Todos los métodos de esta clase tienen la etiqueta @Transactional. lo cual significa que dichos métodos realizarán
transacciones con la base de datos. Antes y después de cada métido se encarga de manera automática de hacer un
transaction begin, un transaction commit y si ocurre algún error un rollback.
Dentro de cada metodo utilizaremos un bloque try-catch para capturar las excepciones.
*/