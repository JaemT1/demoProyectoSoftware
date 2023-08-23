package com.uniquindio.software.service;

import com.uniquindio.software.dao.ILibroDao;
import com.uniquindio.software.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class LibroServiceImpl implements LibroService{
    @Autowired
    private ILibroDao libroDao;
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Libro> listarLibros(String palabraClave) {
        if (palabraClave != null){
            return (ArrayList<Libro>) libroDao.findAll(palabraClave);
        }
        return (ArrayList<Libro>) libroDao.findAll();
    }


    @Override
    @Transactional
    public void guardar(Libro libro) {
        libroDao.save(libro);
    }

    @Override
    @Transactional
    public void eliminar(Libro libro) {
        libroDao.delete(libro);
    }

    @Override
    @Transactional(readOnly = true)
    public Libro encontrarLibro(Libro libro) {
        return libroDao.findById(libro.getCodigoIsbn()).orElse(null);
    }
}
