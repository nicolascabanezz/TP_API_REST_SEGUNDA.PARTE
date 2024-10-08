package com.example.inicial1.controllers;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
/*
Etiqueta @RestController: Se utiliza en aplicaciones web para definir un controlador que manejará solicitudes HTTP
y devolverá respuestas en formato JSON o XML, lo que es común en servicios RESTful.
*/
@CrossOrigin (origins = "*") //Con * indicamos que podremos acceder a la API desde cualquier origen.
/*
Etiqueta @CrossOrigin: se utiliza para permitir (o no) el acceso a nuestra API desde distintos orígenes. Es decir,
desde distintos clientes.
*/
@RequestMapping(path = "api/v1/personas") //A través de esta URI podemos acceder a los métodos de persona
/*
Etiqueta @CrossOrigin: en ella declaramos el path o la URI que necesitamos para acceder a neustros recursos.
*/
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }










}
