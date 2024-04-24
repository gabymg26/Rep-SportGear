package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Model.CatImplementos;
import com.sportgear.sportgear.Model.Estado;
import com.sportgear.sportgear.Model.Inventario;
import com.sportgear.sportgear.Service.CatImplementosService;
import com.sportgear.sportgear.Service.EstadosService;
import com.sportgear.sportgear.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private CatImplementosService catImplementosService;

    @Autowired
    private EstadosService estadosService;

    @GetMapping("/inventarioImplementos")
    public String listarInventario(Model model, @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 5);
        Page<Inventario> listadoInventario = inventarioService.listarInventarioPaginado(pageable);
        model.addAttribute("titulo","Lista de Inventario");
        model.addAttribute("inventario",listadoInventario);
        return "listarInventario";
    }

    @GetMapping("/crearImplemento")
    public String crear(Model model){
        Inventario inventario = new Inventario();
        List<CatImplementos> listCategorias = catImplementosService.listarCategorias();
        List<Estado> listEstados = estadosService.listarEstados();
        model.addAttribute("titulo","Agregar un Implemento");
        model.addAttribute("implemento",inventario);
        model.addAttribute("categorias",listCategorias);
        model.addAttribute("estados",listEstados);
        return "crearImplemento";
    }

    @PostMapping("/guardarImplemento")
    public String guardar(@ModelAttribute Inventario inventario,
                          RedirectAttributes redirectAttributes,
                          @RequestParam(name = "flexSwitchCheckDefault", required = false) String flexSwitchCheckDefault) {

        String disponibilidad = flexSwitchCheckDefault != null ? "Disponible" : "No Disponible";
        inventario.setDisponibilidad(disponibilidad);
        inventarioService.guardar(inventario);
        redirectAttributes.addFlashAttribute("success","Implemento guardado con éxito");
        return "redirect:/admin/inventarioImplementos";
    }


    @GetMapping("/editarImplemento/{id}")
    public String editar(@PathVariable("id")Long idInventario, Model model, RedirectAttributes redirectAttributes){

        Inventario inventario = null;

        if(idInventario > 0){
            inventario = inventarioService.buscarPorId(idInventario);

            if(inventario == null){
                redirectAttributes.addFlashAttribute("error", "Atención: El Id del implemento no existe!");
                return "redirect:/admin/inventarioImplementos";
            }
        }else {
            redirectAttributes.addFlashAttribute("error", "Atención: Error con el Id del implemento");
            return "redirect:/admin/inventarioImplementos";
        }

        List<CatImplementos> listCategorias = catImplementosService.listarCategorias();
        List<Estado> listEstados = estadosService.listarEstados();
        model.addAttribute("titulo","Editar Implemento");
        model.addAttribute("implemento",inventario);
        model.addAttribute("categorias",listCategorias);
        model.addAttribute("estados",listEstados);
        return "crearImplemento";
    }

    @GetMapping("/eliminarImplemento/{id}")
    public String eliminar(@PathVariable ("id")Long idInventario, RedirectAttributes redirectAttributes){

        Inventario inventario = null;

        if(idInventario > 0){
            inventario = inventarioService.buscarPorId(idInventario);

            if(inventario == null){
                redirectAttributes.addFlashAttribute("error", "Atención: El Id del implemento no existe!");
                return "redirect:/admin/inventarioImplementos";
            }
        }else {
            redirectAttributes.addFlashAttribute("error", "Atención: El Id del implemento no existe!");
            return "redirect:/admin/inventarioImplementos";
        }

        inventarioService.eliminar(idInventario);
        redirectAttributes.addFlashAttribute("warning", "Implemento eliminado con éxito");
        return "redirect:/admin/inventarioImplementos";
    }
}
