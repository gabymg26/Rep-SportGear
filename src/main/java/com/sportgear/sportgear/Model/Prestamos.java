package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table
public class Prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate fechaPrestamo;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "idInventario")
    private Inventario inventario;

    @Override
    public String toString() {
        return "Prestamos{" +
                "id=" + id +
                ", fechaPrestamo=" + fechaPrestamo +
                ", usuario=" + usuario +
                ", inventario=" + inventario +
                '}';
    }
}
