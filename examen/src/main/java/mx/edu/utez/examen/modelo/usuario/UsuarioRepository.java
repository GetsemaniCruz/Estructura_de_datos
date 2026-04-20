package mx.edu.utez.examen.modelo.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<BeanUsuario, Integer> {


}
