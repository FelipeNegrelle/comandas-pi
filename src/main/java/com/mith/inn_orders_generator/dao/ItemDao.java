package com.mith.inn_orders_generator.dao;

import com.mith.inn_orders_generator.domain.Item;

import java.util.List;

public interface ItemDao {
    void save(Item item);
    void update(Item item);
    void delete(Integer id);
    Item findById(Integer id);
    List<Item> findAll();
}
