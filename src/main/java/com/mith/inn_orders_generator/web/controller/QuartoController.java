package com.mith.inn_orders_generator.web.controller;

import com.mith.inn_orders_generator.domain.Quarto;
import com.mith.inn_orders_generator.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quarto")
public class QuartoController {
    @Autowired
    private QuartoService service;
    @GetMapping("/cadastrar")
    public String cadastrar(Quarto quarto){
        return "/quarto/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("quarto", service.buscarTodos());
        return "/quarto/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Quarto quarto){
        service.salvar(quarto);
        return "redirect:/quarto/cadastrar";
    }
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Byte id, ModelMap model) {
        model.addAttribute("quarto", service.buscarPorId(id));
        return "/quarto/cadastro";
    }
    @PostMapping("/editar")
    public String editar(Quarto quarto){
        service.editar(quarto);
        return "redirect:/quarto/listar";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Byte id, ModelMap model){
        Quarto quarto = service.buscarPorId(id);
        if (quarto.getHospedes() == null || quarto.getHospedes().isEmpty()){
            service.excluir(id);
        } else {
            model.addAttribute("fail", "Quarto não pode ser excluído. Possui hóspedes vinculados.");
        }
        return listar(model);
    }
}
