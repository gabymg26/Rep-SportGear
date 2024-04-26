package com.sportgear.sportgear.Controller;

import com.sportgear.sportgear.Model.CatImplementos;
import com.sportgear.sportgear.Service.CatImplementosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador para la gestión de categorías de implementos deportivos en el sistema.
 */
@Controller
@RequestMapping("/admin")
public class CategoriaController {

    @Autowired
    private CatImplementosService catImplementosService;

    /**
     * Maneja las solicitudes GET para mostrar el listado paginado de categorías.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @param page El número de página solicitado (por defecto es 0).
     * @return La vista para mostrar el listado de categorías.
     */
    @GetMapping("/listarCategorias")
    public String listarCategorias(Model model, @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 10);
        Page<CatImplementos> listadoInventario = catImplementosService.listarCategoriasPaginado(pageable);
        model.addAttribute("titulo","Lista de Categorias");
        model.addAttribute("categorias",listadoInventario);
        return "listarCategorias";
    }

    /**
     * Maneja las solicitudes GET para mostrar el formulario de creación de categorías.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @return La vista para mostrar el formulario de creación de categorías.
     */
    @GetMapping("/nuevaCategoria")
    public String crear(Model model){
        CatImplementos catImplementos = new CatImplementos();
        model.addAttribute("titulo","Agregar una Categoria");
        model.addAttribute("categoria",catImplementos);
        return "crearCategoria";
    }

    /**
     * Maneja las solicitudes POST para guardar una nueva categoría.
     *
     * @param catImplementos El objeto CatImplementos que representa la categoría a guardar.
     * @param redirectAttributes Atributos para redireccionamiento flash.
     * @return Redirecciona al formulario de creación de implementos con un mensaje de éxito.
     */
    @PostMapping("/guardarCategoria")
    public String guadar(@ModelAttribute("categorias") CatImplementos catImplementos,
                         RedirectAttributes redirectAttributes){
        catImplementosService.guadar_categoria(catImplementos);
        redirectAttributes.addFlashAttribute("success","Categoria creada con Éxito");
        return "redirect:/admin/crearImplemento";
    }

}
