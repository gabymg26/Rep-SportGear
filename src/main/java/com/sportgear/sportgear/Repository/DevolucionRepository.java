package com.sportgear.sportgear.Repository;

import com.sportgear.sportgear.Model.Devoluciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona métodos para acceder y manipular datos de devoluciones en la base de datos.
 */
@Repository
public interface DevolucionRepository extends JpaRepository<Devoluciones, Long> {
}
