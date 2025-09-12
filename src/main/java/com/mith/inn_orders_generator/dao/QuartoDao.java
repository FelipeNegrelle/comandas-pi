package com.mith.inn_orders_generator.dao;

import com.mith.inn_orders_generator.domain.Quarto;

import java.util.List;

public interface QuartoDao {
    void save(Quarto quarto);
    void update(Quarto quarto);
    void delete(Byte id);
    Quarto findById(Byte id);
    List<Quarto> findAll();
}
