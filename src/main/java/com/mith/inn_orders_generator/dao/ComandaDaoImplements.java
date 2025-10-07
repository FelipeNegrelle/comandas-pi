package com.mith.inn_orders_generator.dao;

import com.mith.inn_orders_generator.domain.Comanda;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComandaDaoImplements extends AbstractDao<Comanda, Long> implements ComandaDao {
    @Override
    public List<Comanda> findByEstaFechadaFalse() {
        String jpql = "select c from Comanda c where c.estaFechada = false";
        return getEntityManager()
                .createQuery(jpql, Comanda.class)
                .getResultList();
    }
}
