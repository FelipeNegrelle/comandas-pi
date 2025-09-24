package com.mith.inn_orders_generator.dao;

import com.mith.inn_orders_generator.domain.Comanda;

import java.util.List;

public interface ComandaDao {
    void save(Comanda comanda);
    void update(Comanda comanda);
    void delete(Integer id);
    Comanda findById(Integer id);
    List<Comanda> findAll();
}
