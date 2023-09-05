package com.uniquindio.software.dao;

import com.uniquindio.software.domain.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILibroDao extends CrudRepository<Libro,String> {
    @Query("SELECT p FROM Libro p WHERE"
            + " CONCAT(p.titulo, p.autor,p.codigoIsbn)"
            + " LIKE %?1%")
    List<Libro> findAll(String palabraClave);

    @Query("SELECT p FROM Libro p" +
            " WHERE (p.autor IS NULL OR p.autor LIKE %?1%)" +
            "   AND (p.titulo IS NULL OR p.titulo LIKE %?2%)" +
            "   AND (p.codigoIsbn IS NULL OR p.codigoIsbn LIKE %?3%)")
    List<Libro> findAllAvanzado(String palabraClaveAutor, String palabraClaveTitulo, String palabraClaveIsbn);


}
