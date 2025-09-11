package com.mith.inn_orders_generator.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "/produto/cadastro";
    }

    @GetMapping("/listar")
    public String listar(){
        return "/produto/lista";
    }
}
