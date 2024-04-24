package com.sportgear.sportgear.Service.Impl;

import com.sportgear.sportgear.Model.Inventario;
import com.sportgear.sportgear.Model.Prestamos;
import com.sportgear.sportgear.Repository.InventarioRepository;
import com.sportgear.sportgear.Repository.PrestamoRepository;
import com.sportgear.sportgear.Service.PrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamosServiceImpl implements PrestamosService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<Prestamos> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public void solicitudPrestamo(Prestamos prestamos) {
        Inventario inventario = prestamos.getInventario();

        int cantidadActual = inventario.getCantidad();
        if(cantidadActual > 0){
            cantidadActual--;
            inventario.setCantidad(cantidadActual);
            if(cantidadActual == 0){
                inventario.setDisponibilidad("No Disponible");
            }
            inventarioRepository.save(inventario);
        }
        prestamoRepository.save(prestamos);
    }

    @Override
    public Page<Prestamos> listarPrestamosPaginado(Pageable pageable) {
        return prestamoRepository.findAll(pageable);
    }
}
