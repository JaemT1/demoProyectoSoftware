package com.uniquindio.software.dao;

import com.uniquindio.software.domain.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILibroDao extends CrudRepository<Libro,String> {
    @Query("SELECT p FROM Libro p WHERE"
            + " CONCAT(p.titulo,p.autor,p.codigoIsbn)"
            + " LIKE %?1%")
    List<Libro> findAll(String palabraClave);
}
