package mx.edu.utez.examen.controller;

import mx.edu.utez.examen.controller.dto.PrestamoDto;
import mx.edu.utez.examen.modelo.equipo.BeanEquipo;
import mx.edu.utez.examen.modelo.prestamo.BeanPrestamo;
import mx.edu.utez.examen.service.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamo")
@CrossOrigin({"*"})
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping("/solicitar")
    public ResponseEntity<BeanPrestamo> solicitar(@RequestBody PrestamoDto dto) {
        return ResponseEntity.ok(prestamoService.solicitarPrestamo(dto));
    }

    @PutMapping("/aprobar/{id}")
    public ResponseEntity<BeanPrestamo> aprobar(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.aprobarPrestamo(id));
    }

    @PutMapping("/devolver/{id}")
    public ResponseEntity<BeanPrestamo> devolver(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.registrarDevolucion(id));
    }

    @PutMapping("/rechazar/{id}")
    public ResponseEntity<BeanPrestamo> rechazar(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.rechazarPrestamo(id));
    }

    @GetMapping("/buscar-equipo")
    public ResponseEntity<List<BeanEquipo>> buscarEquipos(@RequestParam String nombre) {
        return ResponseEntity.ok(prestamoService.buscarEquipoDisponiblePorNombre(nombre));
    }
}