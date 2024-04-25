package com.sportgear.sportgear.Repository;

import com.sportgear.sportgear.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que define el repositorio para la entidad Usuario en la base de datos.
 * Se extiende JpaRepository para heredar métodos de operaciones CRUD proporcionados por Spring Data JPA.
 */

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    /**
     * Método que busca un usuario por su dirección de correo electrónico.
     * @param email Dirección de correo electrónico del usuario a buscar.
     * @return El usuario encontrado o null si no se encuentra.
     */

    public Usuario findByEmail(String email);

    /**
     * Método que verifica si existe un usuario con una dirección de correo electrónico dada.
     * @param email Dirección de correo electrónico a verificar.
     * @return true si existe un usuario con la dirección de correo electrónico dada, false si no existe.
     */

    boolean existsByEmail(String email);
}