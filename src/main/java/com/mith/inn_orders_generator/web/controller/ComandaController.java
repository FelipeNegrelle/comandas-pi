package com.mith.inn_orders_generator.web.controller;

import com.mith.inn_orders_generator.domain.Comanda;
import com.mith.inn_orders_generator.service.ClienteService;
import com.mith.inn_orders_generator.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comandas")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/nova")
    public String novaComanda(ModelMap model) {
        model.addAttribute("comanda", new Comanda());
        model.addAttribute("clientes", clienteService.buscarTodos());
        return "/comanda/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("comanda") Comanda comanda) {
        if (comanda.getTotal() == null) comanda.setTotal(0.0);
        comanda.setEstaFechada(false);
        comandaService.salvar(comanda);
        return "redirect:/home"; // volta para home após salvar
    }
}
