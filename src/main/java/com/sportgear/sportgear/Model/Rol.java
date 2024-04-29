package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Rol en la base de datos.
 */

@Entity
@Setter
@Getter
@Table(name="TiposUsuarios")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoUsuario;

    private String nombre;

    /**
     * Constructor parametrizado para crear un objeto Rol.
     * @param idTipoUsuario Identificador único del rol.
     * @param nombre Nombre del rol.
     */

    public Rol(Long idTipoUsuario, String nombre) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombre = nombre;
    }

    /**
     * Constructor por defecto de la clase Rol.
     */

    public Rol() {

    }

    /**
     * Constructor parametrizado para crear un objeto Rol sin especificar el identificador único.
     * @param nombre Nombre del rol.
     */

    public Rol(String nombre) {
        this.nombre = nombre;
    }
}