package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Controller.dto.UsuarioRegistroDTO;
import com.sportgear.sportgear.Repository.UsuarioRepositorio;
import com.sportgear.sportgear.Service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

/**
 * Controlador encargado de manejar las operaciones relacionadas con el registro de usuarios.
 */

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    /**
     * Constructor de la clase RegistroUsuarioControlador.
     * @param usuarioServicio Servicio de usuario.
     * @param usuarioRepository Repositorio de usuarios.
     */

    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio, UsuarioRepositorio usuarioRepository) {
        this.usuarioServicio = usuarioServicio;
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Método que retorna un nuevo objeto UsuarioRegistroDTO como modelo.
     * @return Nuevo objeto UsuarioRegistroDTO.
     */

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    /**
     * Maneja las solicitudes GET para mostrar el formulario de registro de usuarios.
     * @param model Modelo utilizado para agregar atributos al formulario.
     * @return La vista del formulario de registro.
     */

    @GetMapping
    public String mostrarFormularioDeRegistro(Model model) {
        List<String> rolesDisponibles = Arrays.asList("Estudiante", "Administrativo");
        model.addAttribute("roles", rolesDisponibles);
        return "/registro";
    }

    /**
     * Maneja las solicitudes POST para registrar una nueva cuenta de usuario.
     * @param registroDTO DTO del usuario a registrar.
     * @param rol Rol del usuario.
     * @param model Modelo utilizado para agregar atributos a la vista.
     * @return Redirección a la página de registro con un mensaje de éxito o error.
     */

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO, @RequestParam("rol") String rol,Model model) {
        if (usuarioRepository.existsByEmail(registroDTO.getEmail())) {
            model.addAttribute("error", "El correo electrónico ya está registrado");
            List<String> rolesDisponibles = Arrays.asList("Estudiante", "Administrativo");
            model.addAttribute("roles", rolesDisponibles);
            return "/registro";
        } else {
            usuarioServicio.guardar(registroDTO, rol);
            return "redirect:/registro?exito";
        }
    }
}

