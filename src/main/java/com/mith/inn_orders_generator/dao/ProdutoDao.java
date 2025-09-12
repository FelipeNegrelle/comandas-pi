package com.mith.inn_orders_generator.dao;

import com.mith.inn_orders_generator.domain.Produto;

import java.util.List;

public interface ProdutoDao {
    void save(Produto produto);
    void update(Produto produto);
    void delete(Integer id);
    Produto findById(Integer id);
    List<Produto> findAll();
}
