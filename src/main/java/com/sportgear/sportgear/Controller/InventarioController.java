package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Model.CatImplementos;
import com.sportgear.sportgear.Model.Estado;
import com.sportgear.sportgear.Model.Inventario;
import com.sportgear.sportgear.Service.CatImplementosService;
import com.sportgear.sportgear.Service.EstadosService;
import com.sportgear.sportgear.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/administrador")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private CatImplementosService catImplementosService;

    @Autowired
    private EstadosService estadosService;

    @GetMapping("/inventario")
    public String listarInventario(Model model){
        List<Inventario> listadoInventario = inventarioService.listarInventario();
        model.addAttribute("titulo","Lista de Inventario");
        model.addAttribute("inventario",listadoInventario);
        return "listar_inventario";
    }

    @GetMapping("/crear_implemento")
    public String crear(Model model){
        Inventario inventario = new Inventario();
        inventario.setDisponibilidad(true);
        List<CatImplementos> listCategorias = catImplementosService.listarCategorias();
        List<Estado> listEstados = estadosService.listarEstados();
        model.addAttribute("titulo","Agregar un Implemento");
        model.addAttribute("implemento",inventario);
        model.addAttribute("categorias",listCategorias);
        model.addAttribute("estados",listEstados);
        return "crear_implemento";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Inventario inventario,
                          RedirectAttributes redirectAttributes){
        inventarioService.guardar(inventario);
        redirectAttributes.addFlashAttribute("success","Implemento guardado con éxito");
        return "redirect:/administrador/inventario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id")Long idInventario, Model model, RedirectAttributes redirectAttributes){

        Inventario inventario = null;

        if(idInventario > 0){
            inventario = inventarioService.buscarPorId(idInventario);

            if(inventario == null){
                redirectAttributes.addFlashAttribute("error", "Atención: El Id del implemento no existe!");
                return "redirect:/administrador/inventario";
            }
        }else {
            redirectAttributes.addFlashAttribute("error", "Atención: Error con el Id del implemento");
            return "redirect:/administrador/inventario";
        }

        List<CatImplementos> listCategorias = catImplementosService.listarCategorias();
        List<Estado> listEstados = estadosService.listarEstados();
        model.addAttribute("titulo","Editar Implemento");
        model.addAttribute("implemento",inventario);
        model.addAttribute("categorias",listCategorias);
        model.addAttribute("estados",listEstados);
        return "crear_implemento";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable ("id")Long idInventario, RedirectAttributes redirectAttributes){

        Inventario inventario = null;

        if(idInventario > 0){
            inventario = inventarioService.buscarPorId(idInventario);

            if(inventario == null){
                redirectAttributes.addFlashAttribute("error", "Atención: El Id del implemento no existe!");
                return "redirect:/administrador/inventario";
            }
        }else {
            redirectAttributes.addFlashAttribute("error", "Atención: El Id del implemento no existe!");
            return "redirect:/administrador/inventario";
        }

        inventarioService.eliminar(idInventario);
        redirectAttributes.addFlashAttribute("warning", "Implemento eliminado con éxito");
        return "redirect:/administrador/inventario";
    }
}
