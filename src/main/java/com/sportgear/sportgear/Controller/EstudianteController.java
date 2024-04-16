package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Model.Inventario;
import com.sportgear.sportgear.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/estudiar")
public class EstudianteController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/listaInventario")
    public String verInventario(Model model){
        List<Inventario> inventarioList = inventarioService.listarInventario();
        model.addAttribute("titulo","Lista Implementos");
        model.addAttribute("inventario",inventarioList);
        return "panel";
    }

}
