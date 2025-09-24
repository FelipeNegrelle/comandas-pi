package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.domain.Cliente;

import java.util.List;

public interface ClienteService {
    void salvar(Cliente cliente);

    void editar(Cliente cliente);

    void excluir(Integer id);

    Cliente buscarPorId(Integer id);

    List<Cliente> buscarTodos();
}
