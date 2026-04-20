package mx.edu.utez.examen.modelo.equipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<BeanEquipo,Integer> {
    List<BeanEquipo> findByNombreContainingAndDisponibleTrue(String nombre);
}
