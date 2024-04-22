package com.sportgear.sportgear.Service.Impl;

import com.sportgear.sportgear.Model.Estado;
import com.sportgear.sportgear.Model.Inventario;
import com.sportgear.sportgear.Repository.EstadosRepository;
import com.sportgear.sportgear.Repository.InventarioRepository;
import com.sportgear.sportgear.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> listarInventario() {return (List<Inventario>) inventarioRepository.findAll();}

    public Page<Inventario> listarInventarioPaginado(Pageable pageable) {
        return inventarioRepository.findAll(pageable);
    }

    /**
     *
     * @param inventario
     */

    @Override
    public void guardar(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    @Override
    public Inventario buscarPorId(Long id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        inventarioRepository.deleteById(id);
    }

}
