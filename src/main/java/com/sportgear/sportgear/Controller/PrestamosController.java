package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Model.Prestamos;
import com.sportgear.sportgear.Service.PrestamosService;
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
public class PrestamosController {

    @Autowired
    private PrestamosService prestamosService;

    @GetMapping("/seguimientoPrestamos")
    public String listarPrestamos(Model model,@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 10);
        Page<Prestamos> listadoPrestamos = prestamosService.listarPrestamosPaginado(pageable);
        model.addAttribute("titulo","Seguimiento de Prestamos");
        model.addAttribute("prestamos",listadoPrestamos);
        return "listarPrestamos";
    }

}
