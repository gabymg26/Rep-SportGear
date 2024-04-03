package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreImplemento;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CatImplementos catImplementos;

    private boolean disponibilidad;

    private String estado;

    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", nombreImplemento='" + nombreImplemento + '\'' +
                ", cantidad=" + cantidad +
                ", disponibilidad=" + disponibilidad +
                ", estado='" + estado + '\'' +
                '}';
    }
}
