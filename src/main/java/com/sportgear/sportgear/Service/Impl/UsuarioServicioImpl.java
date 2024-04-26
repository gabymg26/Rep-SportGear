package com.sportgear.sportgear.Service.Impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import com.sportgear.sportgear.Service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.sportgear.sportgear.Controller.dto.UsuarioRegistroDTO;
import com.sportgear.sportgear.Model.Rol;
import com.sportgear.sportgear.Model.Usuario;
import com.sportgear.sportgear.Repository.UsuarioRepositorio;

/**
 * Implementación de la interfaz UsuarioServicio que proporciona los servicios relacionados con la entidad Usuario.
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Método para guardar un nuevo usuario en la base de datos.
     * @param registroDTO DTO que contiene la información del usuario a guardar.
     * @param rol Rol asignado al usuario.
     * @return El usuario guardado en la base de datos.
     * @throws IllegalArgumentException Si la contraseña o el rol son nulos.
     */

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO, String rol) {

        if (registroDTO.getPassword() == null || rol == null) {
            throw new IllegalArgumentException("Contraseña o rol no pueden ser nulos");
        }

        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getApellido(), registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()),
                Arrays.asList(new Rol(rol)),
                registroDTO.getCodigo(), registroDTO.getTelefono(),registroDTO.getPrograma());

        return usuarioRepositorio.save(usuario);
    }

    /**
     * Método que carga los detalles del usuario por su nombre de usuario (correo electrónico).
     * @param username Nombre de usuario (correo electrónico).
     * @return Detalles del usuario.
     * @throws UsernameNotFoundException Excepción si el usuario no es encontrado.
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    /**
     * Método para mapear los roles de usuario a autoridades de Spring Security.
     * @param roles Lista de roles del usuario.
     * @return Lista de autoridades de Spring Security.
     */

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    /**
     * Método para obtener la lista de todos los usuarios registrados en la base de datos.
     * @return Lista de usuarios registrados.
     */

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

}

