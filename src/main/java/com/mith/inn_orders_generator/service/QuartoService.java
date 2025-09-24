package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.domain.Quarto;

import java.util.List;

public interface QuartoService {
    void salvar(Quarto quarto);

    void editar(Quarto quarto);

    void excluir(Byte id);

    Quarto buscarPorId(Byte id);

    List<Quarto> buscarTodos();
}
