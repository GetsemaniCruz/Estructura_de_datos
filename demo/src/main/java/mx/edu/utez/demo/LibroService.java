package mx.edu.utez.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService {

    private List<Libro> inventario = new ArrayList<>(List.of(
            new Libro(1L,"El principito", "Grabriel Fernandez", 2000),
            new Libro(2L,"Como Agua para chocolate", "Marcos Peña", 2000),
            new Libro(3L,"La bella y la bestia", "Sofia Castelar", 2000),
            new Libro(4L,"Entre nosostros", "David Valadez", 2000),
            new Libro(5L,"Antes de ti", "Maria Jimenez", 2000)
    ));

    public List<Libro> obtenerCatalogo() {
        return inventario;
    }

    public Libro buscarPorId(Long id) {
        return inventario.stream()
                .filter(libro -> libro.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


}
