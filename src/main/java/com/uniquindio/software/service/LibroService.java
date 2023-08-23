package com.uniquindio.software.service;

import com.uniquindio.software.domain.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> listarLibros(String palabraClave);

    void guardar(Libro libro);

    void eliminar(Libro libro);

    Libro encontrarLibro(Libro libro);
}
