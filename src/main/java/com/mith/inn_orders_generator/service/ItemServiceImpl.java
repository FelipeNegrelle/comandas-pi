package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.dao.ItemDao;
import com.mith.inn_orders_generator.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao dao;

    @Override
    public void salvar(Item item) {
        dao.save(item);
    }

    @Override
    public void editar(Item item) {
        dao.update(item);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Item buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Item> buscarTodos() {
        return dao.findAll();
    }
}
