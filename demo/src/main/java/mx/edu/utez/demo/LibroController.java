package mx.edu.utez.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;
    @GetMapping
    public List<Libro> getTodosLosLibros() {
        return libroService.obtenerCatalogo();
    }

    @GetMapping("/{id}")
    public Libro getLibroPorId(@PathVariable Long id) {
        return libroService.buscarPorId(id);
    }
}