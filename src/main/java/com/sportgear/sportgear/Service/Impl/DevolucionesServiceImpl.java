package com.sportgear.sportgear.Service.Impl;

import com.sportgear.sportgear.Model.Devoluciones;
import com.sportgear.sportgear.Model.Inventario;
import com.sportgear.sportgear.Repository.DevolucionRepository;
import com.sportgear.sportgear.Repository.InventarioRepository;
import com.sportgear.sportgear.Service.DevolucionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevolucionesServiceImpl implements DevolucionesService {

    @Autowired
    private DevolucionRepository devolucionRepository;

    @Autowired
    private InventarioRepository inventarioRepository;

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
}
