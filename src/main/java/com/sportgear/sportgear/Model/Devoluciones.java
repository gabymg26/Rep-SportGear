package com.sportgear.sportgear.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "devoluciones")
public class Devoluciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Falta fecha de Devolución
    private Date fechaDevolucion;

    private String estadoDevolucion;

    @OneToOne
    @JoinColumn(name = "idImplemento")
    private ImplementosDeportivos implementosDeportivos;


    @Override
    public String toString() {
        return "Devoluciones{" +
                "id=" + id +
                ", fechaDevolucion=" + fechaDevolucion +
                ", estadoDevolucion='" + estadoDevolucion + '\'' +
                ", implementosDeportivos=" + implementosDeportivos +
                '}';
    }
}
