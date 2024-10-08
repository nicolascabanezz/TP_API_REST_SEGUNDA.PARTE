package com.example.inicial1.repositories;

import com.example.inicial1.entities.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends BaseRepository <Autor, Long> {
}

/*
- En este caso, AutorRepository tendrá como parámetros Autor como tipo de entidad y Long como tipo de ID.
*/