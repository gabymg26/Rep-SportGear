package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.Devoluciones;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DevolucionesService {

    List<Devoluciones> listarDevoluciones();

    public void solicitudDevolucion(Devoluciones devoluciones);

    public Page<Devoluciones> listarDevolucionesPaginado(Pageable pageable);
}
