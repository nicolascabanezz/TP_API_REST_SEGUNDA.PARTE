package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{

    //Search sin paginación
    List<Persona> search(String filtro) throws Exception;

    //Search con paginación
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;



}
