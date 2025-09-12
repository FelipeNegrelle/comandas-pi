package com.mith.inn_orders_generator.dao;

import com.mith.inn_orders_generator.domain.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImplements extends AbstractDao<Item, Integer> implements ItemDao {
}
