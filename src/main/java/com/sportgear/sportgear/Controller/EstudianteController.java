package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Model.*;
import com.sportgear.sportgear.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/student")
public class EstudianteController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private PrestamosService prestamosService;

    @Autowired
    private DevolucionesService devolucionesService;

    @Autowired
    private EstadosService estadosService;

    @GetMapping("/panelPrincipal")
    public String verInventario(Model model,@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 8);
        Page<Inventario> listadoInventario = inventarioService.listarInventarioPaginado(pageable);
        model.addAttribute("titulo","Lista Implementos");
        model.addAttribute("inventario",listadoInventario);
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
    public String procesarSolicitud(Prestamos prestamo, Principal principal, RedirectAttributes redirectAttributes) {
        String nombreUsuario = principal.getName();
        prestamo.setNombreUsuario(nombreUsuario);
        prestamosService.solicitudPrestamo(prestamo);
        redirectAttributes.addFlashAttribute("success","Solicitud Exitosa");
        return "redirect:/student/panelPrincipal";
    }

    @GetMapping("/devolucion")
    public String devolucion(Model model) {
        Devoluciones devolucion = new Devoluciones();
        List<Inventario> inventarioList = inventarioService.listarInventario();
        List<Estado> estadoList = estadosService.listarEstados();
        model.addAttribute("titulo","Devolucion Implemento");
        model.addAttribute("devolucion",devolucion);
        model.addAttribute("inventario",inventarioList);
        model.addAttribute("estados",estadoList);
        return "devolucion";
    }

    @PostMapping("/guadarDevolucion")
    public String procesarDevolucion(Devoluciones devoluciones,Principal principal,RedirectAttributes redirectAttributes) {
        String nombreUsuario = principal.getName();
        devoluciones.setNombreUsuario(nombreUsuario);
        devolucionesService.solicitudDevolucion(devoluciones);
        redirectAttributes.addFlashAttribute("success","Devolución Exitosa");
        return "redirect:/student/panelPrincipal";
    }

}
