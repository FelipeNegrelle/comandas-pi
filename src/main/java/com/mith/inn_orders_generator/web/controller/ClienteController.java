package com.mith.inn_orders_generator.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "/cliente/cadastro";
    }

    @GetMapping("/listar")
    public String listar(){
        return "/cliente/lista";
    }
}
