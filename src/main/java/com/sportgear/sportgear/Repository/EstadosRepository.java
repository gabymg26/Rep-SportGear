package com.sportgear.sportgear.Repository;

import com.sportgear.sportgear.Model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona métodos para acceder y manipular datos de estados en la base de datos.
 */
@Repository
public interface EstadosRepository extends JpaRepository<Estado,Long> {
}
