package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.domain.Comanda;

import java.util.List;

public interface ComandaService {
    void salvar(Comanda comanda);

    void editar(Comanda comanda);

    void excluir(Integer id);

    Comanda buscarPorId(Integer id);

    List<Comanda> buscarTodos();
}
