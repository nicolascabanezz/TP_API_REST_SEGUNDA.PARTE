package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    //METODOS DE QUERY
    //CONSULTA 1
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);
    /*
        Este metodo retorna una lista de objetos Persona que cumplen al menos una (por eso se utiliza el keyword OR)
        de las siguientes condiciones:

        El nombre contiene el valor proporcionado.
        El apellido contiene el valor proporcionado.

        Por ejemplo, si llamamoss a findByNombreContainingOrApellidoContaining("Juan", "Pérez"),
        se obtendrán todas las Persona cuyo nombre incluya "Juan" o cuyo apellido incluya "Pérez".

        Desventajas:
            Los nombres de los métodos de query son muy largos, por ello no se suelen utilizar con mucha frecuencia.
    */

    //Realizamos una verificación
    //boolean existsByDni(int dni);
    //Este metodo devuelve true si existe al menos un objeto Persona con el DNI proporcionado, y false si no existe.

    //REALIZAMOS CONSULTA 1 PERO UTILIZANDO @Query con JPQL
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);





    //REALIZAMOS CONSULTA 1 PERO UTILIZANDO @Query con SQL
    //El metodo es el mismo, solo cambia la instrucción
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            //Hacemos una consulta que nos permite contar la cantidad de páginas
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);







}

/*
Esta interface es un DAO. DAO es un patrón que propone separar por completo la lógica de negocio de la lógica
para acceder a nuestra base de datos.
PersonaRepository se comunica directamente con la base de datos.
JpaRepository es una clase genérica que nos brinda todos los métodos necesarios para poder acceder a nuestra base de
datos, así como también una serie de consultas que podremos utilizar para hacer consultas a la base de datos.
JpaRepository recibe como parámetros la entidad a la cual hace referencia y el tipo de id declarado.
*/