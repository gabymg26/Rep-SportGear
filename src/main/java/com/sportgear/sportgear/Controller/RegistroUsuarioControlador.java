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


@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio, UsuarioRepositorio usuarioRepository) {
        super();
        this.usuarioServicio = usuarioServicio;
        this.usuarioRepository = usuarioRepository;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(Model model) {
        List<String> rolesDisponibles = Arrays.asList("Estudiante", "Administrativo"); // Suponiendo que tengas esta lista de roles
        model.addAttribute("roles", rolesDisponibles);
        return "/registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO, @RequestParam("rol") String rol, Model model) {
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

