package com.mith.inn_orders_generator.dao;

import com.mith.inn_orders_generator.domain.Cliente;

import java.util.List;

public interface ClienteDao {
    void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(Integer id);
    Cliente findById(Integer id);
    List<Cliente> findAll();
}
