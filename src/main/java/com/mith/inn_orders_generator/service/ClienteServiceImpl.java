package com.mith.inn_orders_generator.service;

import com.mith.inn_orders_generator.dao.ClienteDao;
import com.mith.inn_orders_generator.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteDao dao;

    @Override
    public void salvar(Cliente cliente) {
        dao.save(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        dao.update(cliente);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente buscarPorId(Integer id) {
        return dao.findById(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean estaHospedado(Integer id) {
        Cliente cliente = buscarPorId(id);
        return cliente.getQuarto() != null;
    }
}
