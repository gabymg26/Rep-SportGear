package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Programas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombrePrograma;

    @Override
    public String toString() {
        return "Programas{" +
                "id=" + id +
                ", nombrePrograma='" + nombrePrograma + '\'' +
                '}';
    }
}
