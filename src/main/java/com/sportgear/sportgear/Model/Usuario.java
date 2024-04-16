package com.sportgear.sportgear.Model;


import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;
import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name="usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "TipoUsuarios",
            joinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name= "idTipoUsuario", referencedColumnName= "idTipoUsuario")
    )

    private Collection<Rol> roles;

    private Long codigo;

    private Long telefono;

    private String programa;

    public <T> Usuario(String nombre, String apellido, String email, String encode, List<T> list, Long codigo, Long telefono) {
    }

    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles, Long codigo, Long telefono, String programa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.codigo = codigo;
        this.telefono = telefono;
        this.programa = programa;
    }

    public Usuario() {
        super();
    }
}
