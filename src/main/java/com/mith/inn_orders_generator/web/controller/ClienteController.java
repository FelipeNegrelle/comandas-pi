package com.mith.inn_orders_generator.web.controller;

import com.mith.inn_orders_generator.domain.Cliente;
import com.mith.inn_orders_generator.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;
    @GetMapping("/cadastrar")
    public String cadastrar(Cliente cliente){
        return "/cliente/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("cliente", service.buscarTodos());
        return "/cliente/lista";
    }
    @PostMapping("/salvar")
    public String salvar(Cliente cliente){
        service.salvar(cliente);
        return "redirect:/cliente/cadastrar";
    }
}
