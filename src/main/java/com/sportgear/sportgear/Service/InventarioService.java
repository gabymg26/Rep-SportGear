package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.Inventario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface InventarioService {

    public List<Inventario> listarInventario();
    public void guardar(Inventario inventario);
    public Inventario buscarPorId(Long id);
    public void eliminar(Long id);
    public Page<Inventario> listarInventarioPaginado(Pageable pageable);
}
