package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.dao.ProdutoDao;
import com.mith.inn_orders_generator.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class ProdutoServiceImpl implements ProdutoService{
    @Autowired
    private ProdutoDao dao;

    @Override
    public void salvar(Produto produto) {
        dao.save(produto);
    }

    @Override
    public void editar(Produto produto) {
        dao.update(produto);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Produto buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produto> buscarTodos() {
        return dao.findAll();
    }
}
