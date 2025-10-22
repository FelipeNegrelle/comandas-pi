package com.mith.inn_orders_generator.web.controller;

import com.mith.inn_orders_generator.domain.Cliente;
import com.mith.inn_orders_generator.service.ClienteService;
import com.mith.inn_orders_generator.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private QuartoService quartoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Cliente cliente, ModelMap model){
        model.addAttribute("quartos", quartoService.buscarTodos());
        return "/cliente/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("cliente", service.buscarTodos());
        return "/cliente/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Cliente cliente, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("quartos", quartoService.buscarTodos());
            return "/cliente/cadastro";
        }
        service.salvar(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("cliente", service.buscarPorId(id));
        model.addAttribute("quartos", quartoService.buscarTodos());
        return "/cliente/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Cliente cliente, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("quartos", quartoService.buscarTodos());
            return "/cliente/cadastro";
        }
        service.editar(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, ModelMap model){
        if (!service.estaHospedado(id)){
            service.excluir(id);
        }
        return listar(model);
    }
}
