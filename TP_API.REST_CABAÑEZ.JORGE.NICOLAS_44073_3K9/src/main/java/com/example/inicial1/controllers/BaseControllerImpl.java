package com.example.inicial1.controllers;

import com.example.inicial1.entities.Base;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

    @Autowired
    protected S servicio;

    //METODO GET ALL. SE CORRESPONDE CON EL METODO FIND ALL DE NUESTRO SERVICIO.
    @GetMapping("")
    public ResponseEntity<?> getAll() { //Nos brinda las respuestas en formato JSON para nuestra aplicación WEB
        try {
            //Contiene el status de la respuesta, se hace a través de un código de estado HTTP
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        } catch (Exception e) {
            //Utilizamos el formato de respuesta JSON
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    //METODO PARA LA PAGINACION
    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable) { //Nos brinda las respuestas en formato JSON para nuestra aplicación WEB
        try {
            //Contiene el status de la respuesta, se hace a través de un código de estado HTTP
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
        } catch (Exception e) {
            //Utilizamos el formato de respuesta JSON
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    //METODO GET ONE. SE CORRESPONDE CON EL METODO FIND BY ID DE NUESTRO SERVICIO.
    @GetMapping("/{id}")
    //Con @PathVariable indicamos que se trata de una variable que estará dentro de la URI con la cual se accede al recurso.
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    //METODO SAVE. SE CORRESPONDE CON EL METODO SAVE DE NEUSTRO SERVICIO.
    @PostMapping("")
    //Utilizamos @RequestBody para indicar que Persona se encuentra dentro del body del request
    public ResponseEntity<?> save(@RequestBody E entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    //METODO UPDATE. SE CORRESPONDE CON EL METODO UPDATE DE NUESTRO SERVICIO.
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    //METODO DELETE. SE CORRESPONDE CON EL METODO DELETE DE NUESTRO SERVICIO.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

}
