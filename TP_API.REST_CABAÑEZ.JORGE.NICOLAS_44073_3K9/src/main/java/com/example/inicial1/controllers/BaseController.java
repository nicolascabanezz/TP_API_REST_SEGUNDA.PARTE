package com.example.inicial1.controllers;

import com.example.inicial1.entities.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController <E extends Base, ID extends Serializable> {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getAll(Pageable pageable);
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete(@PathVariable ID id);
}

/*
- Esta interface tendrá todas las operaciones básicas que tiene que realizar nuestro controlador.
- ResponseEntity<?> es una clase parametrizada. El signo de pregunta indica que ResponseEntity va a recibir cualquier
tipo que extienda de Object. Es un comodín.
- Este BaseController podemos utilizarlo en todos los proyectos que lo necesitemos.
*/