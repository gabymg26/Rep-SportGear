package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "catImplementos")
public class CatImplementos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @Override
    public String toString() {
        return "CatImplementos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
