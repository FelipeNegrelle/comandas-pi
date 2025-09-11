package com.mith.inn_orders_generator.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "/estoque/cadastro";
    }

    @GetMapping("/listar")
    public String listar(){
        return "/estoque/lista";
    }
}
