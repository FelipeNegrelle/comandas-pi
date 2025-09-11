package com.mith.inn_orders_generator.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/historico")
public class HistoricoController {

    @GetMapping("/listar")
    public String listar(){
        return "/historico/lista";
    }

}
