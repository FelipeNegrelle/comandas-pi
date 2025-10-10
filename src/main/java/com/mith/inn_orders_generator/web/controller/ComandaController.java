package com.mith.inn_orders_generator.web.controller;

import com.mith.inn_orders_generator.domain.Comanda;
import com.mith.inn_orders_generator.domain.Item;
import com.mith.inn_orders_generator.domain.Produto;
import com.mith.inn_orders_generator.domain.Quarto;
import com.mith.inn_orders_generator.dto.ItemDTO;
import com.mith.inn_orders_generator.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/comandas")
public class ComandaController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ComandaService comandaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private QuartoService quartoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/nova")
    public String novaComanda(ModelMap model) {
        model.addAttribute("comanda", new Comanda());
        model.addAttribute("clientes", clienteService.buscarTodos());
        model.addAttribute("itens", itemService.buscarTodos()); // 🔹 já vem DTO
        return "/comanda/cadastro";
    }


    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("comanda") Comanda comanda,
                         @RequestParam("itens[0].itemSelecionado") String itemSelecionado,
                         @RequestParam("itens[0].quantidade") Integer quantidade,
                         @RequestParam("itens[0].valor") Double valor,
                         @RequestParam("itens[0].requerente") String requerente) {

        if (comanda.getTotal() == null) comanda.setTotal(0.0);
        comanda.setEstaFechada(false);

        if (itemSelecionado != null && !itemSelecionado.isEmpty()) {
            String[] parts = itemSelecionado.split("-");
            String tipo = parts[0];
            Long id = Long.parseLong(parts[1]);

            Item item = new Item();
            item.setComanda(comanda);
            item.setValor(valor);
            item.setRequerente(requerente);
            item.setQuantidade(quantidade != null ? quantidade : 1);

            if ("Produto".equalsIgnoreCase(tipo)) {
                Produto produto = produtoService.buscarPorId(id.intValue());
                item.setProduto(produto);
            } else if ("Quarto".equalsIgnoreCase(tipo)) {
                Quarto quarto = quartoService.buscarPorId(id.byteValue());
                item.setQuarto(quarto);
            }

            double totalItem = item.getQuantidade() * (valor != null ? valor : 0.0);
            comanda.setTotal(comanda.getTotal() + totalItem);

            if (comanda.getItens() == null) comanda.setItens(new ArrayList<>());
            comanda.getItens().add(item);
        }

        comandaService.salvar(comanda);
        return "redirect:/";
    }


}
