package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador encargado de manejar las operaciones relacionadas con el inicio de sesión.
 */

@Controller
public class IngresoUsuarioControlador {

    @Autowired
    private UsuarioServicio servicio;

    /**
     * Maneja las solicitudes GET para mostrar la página de inicio de sesión.
     * @return La vista de inicio de sesión.
     */

    @GetMapping("/login")
    public String iniciarSesion(){
        return "/login";
    }

    /**
     * Maneja las solicitudes GET para mostrar la página de inicio.
     * @param modelo Modelo utilizado para agregar atributos a la vista.
     * @return La vista de inicio con la lista de usuarios.
     */


    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo){
        modelo.addAttribute("usuarios",servicio.listarUsuarios());
        return "/login";
    }
}
