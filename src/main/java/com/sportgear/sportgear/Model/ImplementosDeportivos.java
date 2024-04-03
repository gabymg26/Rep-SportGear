package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "implementosDeportivos")
public class ImplementosDeportivos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "idCategoria")
    private CatImplementos catImplementos;

    @OneToOne
    @JoinColumn(name = "idInventario")
    private Inventario inventario;

    @Override
    public String toString() {
        return "ImplementosDeportivos{" +
                "id=" + id +
                ", catImplementos=" + catImplementos +
                ", inventario=" + inventario +
                '}';
    }
}
