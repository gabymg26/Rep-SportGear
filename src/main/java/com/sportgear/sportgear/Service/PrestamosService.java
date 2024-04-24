package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.Prestamos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PrestamosService {

    List<Prestamos> listarPrestamos();

    public void solicitudPrestamo(Prestamos prestamos);

    public Page<Prestamos> listarPrestamosPaginado(Pageable pageable);
}
