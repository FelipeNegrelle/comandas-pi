package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.domain.Item;

import java.util.List;

public interface ItemService {
    void salvar(Item item);

    void editar(Item item);

    void excluir(Integer id);

    Item buscarPorId(Integer id);

    List<Item> buscarTodos();
}
