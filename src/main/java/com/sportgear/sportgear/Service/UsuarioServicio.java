package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Controller.dto.UsuarioRegistroDTO;
import com.sportgear.sportgear.Model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public  interface UsuarioServicio extends UserDetailsService {
    public Usuario guardar(UsuarioRegistroDTO registroDTO, String rol);

    public List<Usuario> listarUsuarios();

}
