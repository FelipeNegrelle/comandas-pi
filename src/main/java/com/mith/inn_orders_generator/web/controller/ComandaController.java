package com.mith.inn_orders_generator.web.controller;

import com.mith.inn_orders_generator.domain.Comanda;
import com.mith.inn_orders_generator.domain.Item;
import com.mith.inn_orders_generator.domain.Produto;
import com.mith.inn_orders_generator.domain.Quarto;
import com.mith.inn_orders_generator.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        return "comanda/cadastro";
    }


    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("comanda") Comanda comanda, HttpServletRequest request) {

        if (comanda.getTotal() == null) comanda.setTotal(0.0);
        comanda.setEstaFechada(false);

        double total = 0.0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if (comanda.getItens() != null) {
            for (int i = 0; i < comanda.getItens().size(); i++) {
                Item item = comanda.getItens().get(i);
                String itemSelecionado = request.getParameter("itens[" + i + "].itemSelecionado");
                String dataParam = request.getParameter("itens[" + i + "].data");

                // se binding não preencheu a data, tenta parsear do parâmetro
                if ((item.getData() == null || item.getData().toString().isEmpty()) && dataParam != null && !dataParam.isEmpty()) {
                    try {
                        Date d = df.parse(dataParam);
                        item.setData(d);
                    } catch (ParseException e) {
                        // ignore, continuará sem data
                    }
                }

                if (itemSelecionado != null && !itemSelecionado.isEmpty()) {
                    String[] parts = itemSelecionado.split("-");
                    String tipo = parts[0];
                    long id = Long.parseLong(parts[1]);

                    if ("Produto".equalsIgnoreCase(tipo)) {
                        Produto produto = produtoService.buscarPorId((int) id);
                        item.setProduto(produto);
                        if (item.getValor() == null) item.setValor(produto.getValor());
                    } else if ("Quarto".equalsIgnoreCase(tipo)) {
                        Quarto quarto = quartoService.buscarPorId((byte) id);
                        item.setQuarto(quarto);
                        if (item.getValor() == null) item.setValor(quarto.getValor());
                    }
                }

                item.setComanda(comanda);

                double valorItem = item.getValor() != null ? item.getValor() : 0.0;
                int qtd = item.getQuantidade() != null ? item.getQuantidade() : 1;
                total += qtd * valorItem;
            }
        }

        comanda.setTotal(total);
        comandaService.salvar(comanda);
        return "redirect:/";
    }

    @GetMapping("/ver/{id}")
    public String visualizar(@PathVariable("id") Long id, ModelMap model, RedirectAttributes redirectAttributes) {
        Comanda comanda = comandaService.buscarPorId(id);
        if (comanda == null) {
            redirectAttributes.addFlashAttribute("fail", "Comanda não encontrada.");
            return "redirect:/";
        }
        model.addAttribute("comanda", comanda);
        return "comanda/visualizar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model, RedirectAttributes redirectAttributes) {
        Comanda comanda = comandaService.buscarPorId(id);
        if (comanda == null) {
            redirectAttributes.addFlashAttribute("fail", "Comanda não encontrada.");
            return "redirect:/";
        }
        model.addAttribute("comanda", comanda);
        model.addAttribute("clientes", clienteService.buscarTodos());
        model.addAttribute("itens", itemService.buscarTodos());
        return "comanda/cadastro"; // formulário de cadastro/edição
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("comanda") Comanda comanda, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        // recalcula total e garante associação de itens semelhante ao salvar
        double total = 0.0;
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

        if (comanda.getItens() != null) {
            for (int i = 0; i < comanda.getItens().size(); i++) {
                Item item = comanda.getItens().get(i);
                String itemSelecionado = request.getParameter("itens[" + i + "].itemSelecionado");
                String dataParam = request.getParameter("itens[" + i + "].data");

                if ((item.getData() == null || item.getData().toString().isEmpty()) && dataParam != null && !dataParam.isEmpty()) {
                    try {
                        Date d = df2.parse(dataParam);
                        item.setData(d);
                    } catch (ParseException e) {
                        // ignore
                    }
                }

                if (itemSelecionado != null && !itemSelecionado.isEmpty()) {
                    String[] parts = itemSelecionado.split("-");
                    String tipo = parts[0];
                    long id = Long.parseLong(parts[1]);

                    if ("Produto".equalsIgnoreCase(tipo)) {
                        Produto produto = produtoService.buscarPorId((int) id);
                        item.setProduto(produto);
                        if (item.getValor() == null) item.setValor(produto.getValor());
                    } else if ("Quarto".equalsIgnoreCase(tipo)) {
                        Quarto quarto = quartoService.buscarPorId((byte) id);
                        item.setQuarto(quarto);
                        if (item.getValor() == null) item.setValor(quarto.getValor());
                    }
                }

                item.setComanda(comanda);

                double valorItem = item.getValor() != null ? item.getValor() : 0.0;
                int qtd = item.getQuantidade() != null ? item.getQuantidade() : 1;
                total += qtd * valorItem;
            }
        }

        comanda.setTotal(total);
        comandaService.editar(comanda);
        redirectAttributes.addFlashAttribute("success", "Comanda atualizada com sucesso.");
        return "redirect:/comandas/ver/" + comanda.getId();
    }

}
