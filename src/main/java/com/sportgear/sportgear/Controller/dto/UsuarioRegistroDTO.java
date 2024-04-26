package com.sportgear.sportgear.Controller.dto;


import com.sportgear.sportgear.Model.Rol;
import lombok.Getter;
import lombok.Setter;
import java.util.Collection;

/**
 * Esta clase representa un objeto de transferencia de datos (DTO) para el registro de usuarios en la aplicación.
 */

@Getter
@Setter
public class UsuarioRegistroDTO {

    /**
     * Identificador único del usuario.
     */

    private Long id;

    /**
     * Nombres y Apellidos del usuario.
     */

    private String nombre;

    private String apellido;

    /**
     * Correo electrónico y contraseña del usuario.
     */

    private String email;

    private String password;

    /**
     * Rol del usuario, (Estudiante o Administrativo).
     */

    private Collection<Rol> rol;

    /**
     * Código institucional del usuario en caso de ser estudiante.
     */

    private Long codigo;

    /**
     * Número telefónico del usuario.
     */

    private Long telefono;

    /**
     * Programa académico del usuario en caso de ser estudiante.
     */

    private String programa;

    /**
     * Constructor de la clase que inicializa todos los atributos.
     */

    public UsuarioRegistroDTO(Long id, String nombre, String apellido, String email, String password, Collection<Rol> rol, Long codigo, Long telefono, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.codigo = codigo;
        this.telefono = telefono;
        this.programa = programa;
    }

    public UsuarioRegistroDTO() {

    }
}
