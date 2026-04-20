package mx.edu.utez.examen.modelo.prestamo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.modelo.usuario.BeanUsuario;

import java.util.List;

@Entity
@Table(name = "prestamo")
@Getter
@Setter
@NoArgsConstructor
public class BeanPrestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fechaSolicitud;
    private String fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private  BeanUsuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private  BeanUsuario equipo;


}
