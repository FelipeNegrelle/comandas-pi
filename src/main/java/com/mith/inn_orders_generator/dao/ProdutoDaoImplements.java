package com.mith.inn_orders_generator.dao;

import com.mith.inn_orders_generator.domain.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDaoImplements extends AbstractDao<Produto, Integer> implements ProdutoDao{

}
