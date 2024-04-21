package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Model.*;
import com.sportgear.sportgear.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class EstudianteController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private PrestamosService prestamosService;

    @GetMapping("/panelPrincipal")
    public String verInventario(Model model){
        List<Inventario> inventarioList = inventarioService.listarInventario();
        model.addAttribute("titulo","Lista Implementos");
        model.addAttribute("inventario",inventarioList);
        return "panel";
    }

    @GetMapping("/solicitud")
    public String solicitud(Model model){
        Prestamos prestamos = new Prestamos();
        List<Inventario> inventarioList = inventarioService.listarInventario();
        model.addAttribute("titulo","Solicitar Implemento");
        model.addAttribute("prestamo", prestamos);
        model.addAttribute("inventario",inventarioList);
        return "solicitud";
    }

    @PostMapping("/guardarPrestamos")
    public String procesarSolicitud(Prestamos prestamo,RedirectAttributes redirectAttributes) {
        prestamosService.solicitudPrestamo(prestamo);
        redirectAttributes.addFlashAttribute("success","Solicitud Exitosa");
        return "redirect:/student/panelPrincipal";
    }

}
