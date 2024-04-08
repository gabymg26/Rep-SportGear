package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEstado;

    private String nombreEstado;

    @Override
    public String toString() {
        return "Estado{" +
                "idEstado=" + idEstado +
                ", nombreEstado='" + nombreEstado + '\'' +
                '}';
    }
}
