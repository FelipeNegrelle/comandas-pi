package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.domain.Produto;

import java.util.List;

public interface ProdutoService {
    void salvar(Produto produto);

    void editar(Produto produto);

    void excluir(Integer id);

    Produto buscarPorId(Integer id);

    List<Produto> buscarTodos();
}
