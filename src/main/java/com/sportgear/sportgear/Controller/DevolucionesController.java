package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Model.Devoluciones;
import com.sportgear.sportgear.Service.DevolucionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class DevolucionesController {

    @Autowired
    private DevolucionesService devolucionesService;

    @GetMapping("/seguimientoDevoluciones")
    public String listarDevoluciones(Model model,@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 10);
        Page<Devoluciones> listadoDevoluciones = devolucionesService.listarDevolucionesPaginado(pageable);
        model.addAttribute("titulo","Seguimiento de Devoluciones");
        model.addAttribute("devoluciones",listadoDevoluciones);
        return "listarDevoluciones";
    }
}
