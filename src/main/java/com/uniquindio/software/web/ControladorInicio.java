package com.uniquindio.software.web;

import com.uniquindio.software.domain.Libro;
import com.uniquindio.software.service.LibroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private LibroService libroService;


    @GetMapping("/")
    public String inicio(Model model, @Param("palabraClave") String palabraClave,
                         @Param("palabraClaveAutor") String palabraClaveAutor, @Param("palabraClaveTitulo") String palabraClaveTitulo, @Param("palabraClaveIsbn") String palabraClaveIsbn) throws InterruptedException {

        var libros = libroService.listarLibros(palabraClave);



        if (palabraClave == null) {
            var libros1 = libroService.listarLibrosAvanzada(palabraClaveAutor, palabraClaveTitulo, palabraClaveIsbn);
            libros = libros1;
        }

        model.addAttribute("palabraClave", palabraClave);
        model.addAttribute("palabraClaveAutor", palabraClaveAutor);
        model.addAttribute("palabraClaveTitulo", palabraClaveTitulo);
        model.addAttribute("palabraClaveIsbn", palabraClaveIsbn);
        model.addAttribute("libros", libros);
        return "vistaCliente";
    }

    @GetMapping("/index")
    public String inicioAdmin(Model model, @Param("palabraClave") String palabraClave) {
        var libros = libroService.listarLibros(palabraClave);
        model.addAttribute("libros", libros);
        model.addAttribute("palabraClave", palabraClave);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Libro libro, Model model) {
        model.addAttribute("libro", libro);
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Libro libro) {
        libroService.guardar(libro);
        return "redirect:/";
    }

    @GetMapping("/editar")
    public String editar(Libro libro, Model model) {
        libro = libroService.encontrarLibro(libro);
        model.addAttribute("libro", libro);
        return "modificar";
    }

    @GetMapping("/visualizar")
    public String visualizar(Libro libro, Model model) {
        libro = libroService.encontrarLibro(libro);
        model.addAttribute("libro", libro);
        return "visualizarLibroVistaCliente";
    }

    @GetMapping("/eliminar")
    public String eliminar(Libro libro) {
        libroService.eliminar(libro);
        return "redirect:/";
    }

}
