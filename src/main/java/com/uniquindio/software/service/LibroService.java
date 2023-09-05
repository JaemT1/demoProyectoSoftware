package com.uniquindio.software.service;

import com.uniquindio.software.domain.Libro;

import java.util.ArrayList;
import java.util.List;

public interface LibroService {
    ArrayList<Libro> listaLibros = new ArrayList<Libro>();
    List<Libro> listarLibros(String palabraClave);
    List<Libro> listarLibrosAvanzada(String palabraClaveAutor, String palabraClaveTitulo, String palabraClaveIsbn);
    void guardar(Libro libro);

    void eliminar(Libro libro);

    Libro encontrarLibro(Libro libro);
}
