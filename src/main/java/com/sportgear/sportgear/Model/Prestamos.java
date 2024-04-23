package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table
public class Prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSolicitud;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaPrestamo;

    private Long codigoUsuario;

    private String nombreUsuario;

    @OneToOne
    @JoinColumn(name = "idInventario")
    private Inventario inventario;

    @Override
    public String toString() {
        return "Prestamos{" +
                "idSolicitud=" + idSolicitud +
                ", fechaPrestamo=" + fechaPrestamo +
                ", codigoUsuario=" + codigoUsuario +
                ", inventario=" + inventario +
                '}';
    }
}
