package com.sportgear.sportgear.Service.Impl;

import com.sportgear.sportgear.Model.Devoluciones;
import com.sportgear.sportgear.Model.Inventario;
import com.sportgear.sportgear.Repository.DevolucionRepository;
import com.sportgear.sportgear.Repository.InventarioRepository;
import com.sportgear.sportgear.Service.DevolucionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucionesServiceImpl implements DevolucionesService {

    @Autowired
    private DevolucionRepository devolucionRepository;

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<Devoluciones> listarDevoluciones() {
        return devolucionRepository.findAll();
    }

    @Override
    public void solicitudDevolucion(Devoluciones devoluciones) {
        Inventario inventario = devoluciones.getInventario();

        int cantidadActual = inventario.getCantidad();
        if(cantidadActual >= 0){
            cantidadActual++;
            inventario.setCantidad(cantidadActual);
            if(cantidadActual > 0){
                inventario.setDisponibilidad("Disponible");
            }
            inventarioRepository.save(inventario);
        }
        devolucionRepository.save(devoluciones);
    }

    @Override
    public Page<Devoluciones> listarDevolucionesPaginado(Pageable pageable) {
        return devolucionRepository.findAll(pageable);
    }
}
