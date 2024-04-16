package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name="TiposUsuarios")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoUsuario;

    private String nombre;

    public Rol(Long idTipoUsuario, String nombre) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombre = nombre;
    }

    public Rol() {
        super();
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }
}