package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Indicamos que esta clase será un servicio
//Esta clase implementa BaseService y envía como parámetro una Persona
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

    @Autowired //Cumple la misma función que el constructor que está comentado en la línea 19
    private PersonaRepository personaRepository;
    /*
    public PersonaService (PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }
    */
    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository){
        super(baseRepository);
    }


    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            //Hacemos la consulta utilizando métodos de query
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);

            //Hacemos la consulta con JPQL
            //List<Persona> personas = personaRepository.search(filtro);

            //Hacemos la consulta con SQL
            List<Persona> personas = personaRepository.searchNativo(filtro);

            //FUNCIONAN PERFECTO

            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Hacemos la consulta utilizando métodos de query
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);

            //Hacemos la consulta con JPQL
            //Page<Persona> personas = personaRepository.search(filtro, pageable);

            //Hacemos la consulta con SQL
            Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);

            //FUNCIONAN PERFECTO

            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }













}

