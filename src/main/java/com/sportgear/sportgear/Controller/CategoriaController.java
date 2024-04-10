package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Model.CatImplementos;
import com.sportgear.sportgear.Service.CatImplementosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/administrador")
public class CategoriaController {

    @Autowired
    private CatImplementosService catImplementosService;

    @GetMapping("/listarCategorias")
    public String listarCategorias(Model model){
        List<CatImplementos> listCategorias = catImplementosService.listarCategorias();
        model.addAttribute("titulo","Lista de Categorias");
        model.addAttribute("categorias",listCategorias);
        return "listarCategorias";
    }

    @GetMapping("/nueva_categoria")
    public String crear(Model model){
        CatImplementos catImplementos = new CatImplementos();
        model.addAttribute("titulo","Agregar una Categoria");
        model.addAttribute("categoria",catImplementos);
        return "crear_categoria";
    }

    @PostMapping("/guardar_categoria")
    public String guadar(@ModelAttribute("categorias") CatImplementos catImplementos,
                         RedirectAttributes redirectAttributes){
        catImplementosService.guadar_categoria(catImplementos);
        redirectAttributes.addFlashAttribute("success","Categoria creada con Éxito");
        return "redirect:/administrador/inventario";
    }

}
