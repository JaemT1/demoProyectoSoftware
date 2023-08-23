package com.uniquindio.software.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Table(name = "libro")
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String codigoIsbn;

    private String titulo;
    private String autor;
    private double calificacion;
    private String resena;

}
