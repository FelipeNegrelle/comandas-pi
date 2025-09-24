package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.dao.ComandaDao;
import com.mith.inn_orders_generator.domain.Comanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class ComandaServiceImpl implements ComandaService{

    @Autowired
    private ComandaDao dao;

    @Override
    public void salvar(Comanda comanda) {
        dao.save(comanda);
    }

    @Override
    public void editar(Comanda comanda) {
        dao.update(comanda);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Comanda buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comanda> buscarTodos() {
        return dao.findAll();
    }
}
