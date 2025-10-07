package com.mith.inn_orders_generator.web.controller;

import com.mith.inn_orders_generator.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    ComandaService service;
    @GetMapping("/")
    public String home(ModelMap model){
        model.addAttribute("comandas", service.listarAbertas());
        return "home";
    }
}
