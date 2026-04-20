package mx.edu.utez.examen.modelo.prestamo;

import mx.edu.utez.examen.modelo.usuario.BeanUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<BeanPrestamo, Integer> {
    long countByUsuarioAndEstadoIn(BeanUsuario usuario, List<String> estados);
}
