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
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaPrestamo;

    private String nombreUsuario;

    private Long codigoUsuario;

    @OneToOne
    @JoinColumn(name = "idInventario")
    private Inventario inventario;

    @Override
    public String toString() {
        return "Prestamos{" +
                "id=" + id +
                ", fechaPrestamo=" + fechaPrestamo +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", codigoUsuario=" + codigoUsuario +
                ", inventario=" + inventario +
                '}';
    }
}
