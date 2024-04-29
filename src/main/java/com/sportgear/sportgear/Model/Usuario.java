package com.sportgear.sportgear.Model;


import lombok.Getter;
import lombok.Setter;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

/**
 * Clase que representa la entidad Usuario en la base de datos.
 */

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

    /**
     * Relación Many-to-Many con la tabla de tipos de usuarios.
     * Se utiliza FetchType.EAGER para cargar los datos relacionados de forma inmediata.
     * Se utiliza CascadeType.ALL para aplicar todas las operaciones de persistencia (insertar, actualizar o eliminar) en cascada.
     */

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
    
    /**
     * Constructor parametrizado para crear un objeto Usuario.
     */

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

    /**
     * Constructor por defecto de la clase Usuario.
     */

    public Usuario() {

    }
}
