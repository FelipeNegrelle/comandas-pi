package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.dao.QuartoDao;
import com.mith.inn_orders_generator.domain.Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class QuartoServiceImpl implements QuartoService {
    @Autowired
    private QuartoDao dao;

    @Override
    public void salvar(Quarto quarto) {
        dao.save(quarto);
    }

    @Override
    public void editar(Quarto quarto) {
        dao.update(quarto);
    }

    @Override
    public void excluir(Byte id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Quarto buscarPorId(Byte id) {
        return dao.findById(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Quarto> buscarTodos() {
        return dao.findAll();
    }
}
