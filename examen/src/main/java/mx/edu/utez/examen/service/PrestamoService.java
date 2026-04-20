package mx.edu.utez.examen.service;

import mx.edu.utez.examen.controller.dto.PrestamoDto;
import mx.edu.utez.examen.modelo.equipo.BeanEquipo;
import mx.edu.utez.examen.modelo.equipo.EquipoRepository;
import mx.edu.utez.examen.modelo.prestamo.BeanPrestamo;
import mx.edu.utez.examen.modelo.prestamo.PrestamoRepository;
import mx.edu.utez.examen.modelo.usuario.BeanUsuario;
import mx.edu.utez.examen.modelo.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final UsuarioRepository usuarioRepository;
    private final EquipoRepository equipoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository, UsuarioRepository usuarioRepository, EquipoRepository equipoRepository) {
        this.prestamoRepository = prestamoRepository;
        this.usuarioRepository = usuarioRepository;
        this.equipoRepository = equipoRepository;
    }

    public BeanPrestamo solicitarPrestamo(PrestamoDto prestamodto) {
        BeanUsuario usuario = usuarioRepository.findById(prestamodto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        BeanEquipo equipo = equipoRepository.findById(prestamodto.getEquipoId())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        BeanPrestamo prestamo = new BeanPrestamo();
        prestamo.setUsuario(usuario);
        prestamo.setEquipo(equipo);
        prestamo.setFechaSolicitud(LocalDateTime.now().toString());

        boolean valido = true;

        if (!usuario.isActivo()) valido = false;
        if (!equipo.isDisponible()) valido = false;

        // Validar máximo 2 préstamos activos (Solicitado o Aprobado)
        long activos = prestamoRepository.countByUsuarioAndEstadoIn(usuario, List.of("SOLICITADO", "APROBADO"));
        if (activos >= 2) valido = false;

        prestamo.setEstado(valido ? "SOLICITADO" : "RECHAZADO");

        return prestamoRepository.save(prestamo);
    }

    public BeanPrestamo aprobarPrestamo(Long id) {
        BeanPrestamo prestamo = prestamoRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("No existe el préstamo"));

        if (!"SOLICITADO".equals(prestamo.getEstado())) {
            throw new RuntimeException("Solo se pueden aprobar préstamos en estado SOLICITADO");
        }

        prestamo.setEstado("APROBADO");

        BeanEquipo equipo = prestamo.getEquipo();
        equipo.setDisponible(false);
        equipoRepository.save(equipo);

        return prestamoRepository.save(prestamo);
    }

    public BeanPrestamo registrarDevolucion(Long id) {
        BeanPrestamo prestamo = prestamoRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("No existe el préstamo"));

        prestamo.setEstado("DEVUELTO");
        prestamo.setFechaDevolucion(LocalDateTime.now().toString());

        BeanEquipo equipo = prestamo.getEquipo();
        equipo.setDisponible(true);
        equipoRepository.save(equipo);

        return prestamoRepository.save(prestamo);
    }

    public BeanPrestamo rechazarPrestamo(Long id) {
        BeanPrestamo prestamo = prestamoRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("No existe el préstamo"));

        if ("SOLICITADO".equals(prestamo.getEstado())) {
            prestamo.setEstado("RECHAZADO");
        }
        return prestamoRepository.save(prestamo);
    }

    public List<BeanEquipo> buscarEquipoDisponiblePorNombre(String nombre) {
        return equipoRepository.findByNombreContainingAndDisponibleTrue(nombre);
    }
}