package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Model.CatImplementos;
import com.sportgear.sportgear.Model.Inventario;
import com.sportgear.sportgear.Service.CatImplementosService;
import com.sportgear.sportgear.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private CatImplementosService catImplementosService;

    @GetMapping("/inventario")
    public String listarInventario(Model model){
        List<Inventario> listadoInventario = inventarioService.listarInventario();
        model.addAttribute("titulo","Lista de Inventario");
        model.addAttribute("inventario",listadoInventario);
        return "/listar_inventario";
    }

    @GetMapping("/crear_implemento")
    public String crear(Model model){
        Inventario inventario = new Inventario();
        List<CatImplementos> listCategorias = catImplementosService.listarCategorias();
        model.addAttribute("titulo","Nuevo Implemento");
        model.addAttribute("implemento",inventario);
        model.addAttribute("categorias",listCategorias);
        return "/crear_implemento";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Inventario inventario,
                          RedirectAttributes redirectAttributes){
        inventarioService.guardar(inventario);
        redirectAttributes.addFlashAttribute("success","Implemento guardado con Exito");
        return "redirect:/inventario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id")Long idInventario, Model model, RedirectAttributes redirectAttributes){

        Inventario inventario = null;

        if(idInventario > 0){
            inventario = inventarioService.buscarPorId(idInventario);

            if(inventario == null){
                redirectAttributes.addFlashAttribute("error", "Atención: El Id del Implemento no Existe!");
                return "redirect:/inventario";
            }
        }else {
            redirectAttributes.addFlashAttribute("error", "Atención: Error con el Id del Implemento");
            return "redirect:/inventario";
        }

        List<CatImplementos> listCategorias = catImplementosService.listarCategorias();
        model.addAttribute("titulo","Formulario : Editar Implemento");
        model.addAttribute("implemento",inventario);
        model.addAttribute("categorias",listCategorias);
        return "/crear_implemento";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable ("id")Long idInventario, RedirectAttributes redirectAttributes){

        Inventario inventario = null;

        if(idInventario > 0){
            inventario = inventarioService.buscarPorId(idInventario);

            if(inventario == null){
                redirectAttributes.addFlashAttribute("error", "Atención: El Id del Implemento no Existe!");
                return "redirect:/inventario";
            }
        }else {
            redirectAttributes.addFlashAttribute("error", "Atención: El Id del Implemento no Existe!");
            return "redirect:/inventario";
        }

        inventarioService.eliminar(idInventario);
        redirectAttributes.addFlashAttribute("warning", "Implemento Eliminado Con Éxito");
        return "redirect:/inventario";
    }
}
