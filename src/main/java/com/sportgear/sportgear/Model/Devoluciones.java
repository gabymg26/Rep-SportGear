package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "devoluciones")
public class Devoluciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDevolucion;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDevolucion;

    private Long codigoUsuario;

    private String nombreUsuario;

    private String estadoDevolucion;

    @OneToOne
    @JoinColumn(name = "idInventario")
    private Inventario inventario;

    @Override
    public String toString() {
        return "Devoluciones{" +
                "id=" + idDevolucion +
                ", fechaDevolucion=" + fechaDevolucion +
                ", estadoDevolucion='" + estadoDevolucion + '\'' +
                ", inventario=" + inventario +
                '}';
    }
}
