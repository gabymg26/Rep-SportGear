package com.sportgear.sportgear.Controller.dto;


import com.sportgear.sportgear.Model.Rol;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class UsuarioRegistroDTO {

    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String password;

    private Collection<Rol> rol;

    private Long codigo;

    private Long telefono;

    private String programa;

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
