package mx.edu.utez.examen.controller.dto;

import lombok.Data;

@Data
public class UsuarioDto {

    private String nombre;
    private String tipoUsuario;
    private boolean activo;
}
