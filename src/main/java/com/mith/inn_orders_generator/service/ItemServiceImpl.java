package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.dao.ItemDao;
import com.mith.inn_orders_generator.domain.Item;
import com.mith.inn_orders_generator.domain.Produto;
import com.mith.inn_orders_generator.domain.Quarto;
import com.mith.inn_orders_generator.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = false)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao dao;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private QuartoService quartoService;

    @Override
    public void salvar(Item item) {
        dao.save(item);
    }

    @Override
    public void editar(Item item) {
        dao.update(item);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Item buscarPorId(Integer id) {
        return dao.findById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public List<ItemDTO> buscarTodos() {
        List<ItemDTO> itens = new ArrayList<>();

        for (Produto produto : produtoService.buscarTodos()) {
            itens.add(new ItemDTO(produto.getId().longValue(), produto.getDescr(), "Produto"));
        }

        for (Quarto quarto : quartoService.buscarTodos()) {
            itens.add(new ItemDTO(quarto.getId().longValue(), "Quarto " + quarto.getTipo(), "Quarto"));
        }

        return itens;
    }
}
