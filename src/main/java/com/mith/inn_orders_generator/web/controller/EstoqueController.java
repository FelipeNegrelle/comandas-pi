package com.mith.inn_orders_generator.web.controller;

import com.mith.inn_orders_generator.domain.Produto;
import com.mith.inn_orders_generator.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private ProdutoService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Produto produto){
        return "/estoque/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("produto", service.buscarTodos());
        return "/estoque/lista";
    }
    @PostMapping("/salvar")
    public String salvar(Produto produto){
        service.salvar(produto);
        return "redirect:/estoque/listar";
    }
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("produto", service.buscarPorId(id));
        return "/estoque/cadastro";
    }
    @PostMapping("/editar")
    public String editar(Produto produto){
        service.editar(produto);
        return "redirect:/estoque/listar";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, ModelMap model){
        service.excluir(id);
        return listar(model);
    }
}
