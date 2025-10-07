package com.mith.inn_orders_generator.web.converter;

import com.mith.inn_orders_generator.domain.Cliente;
import com.mith.inn_orders_generator.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter implements Converter<String, Cliente> {

    @Autowired
    private ClienteService clienteService;

    @Override
    public Cliente convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        Integer clienteId = Integer.valueOf(id);
        return clienteService.buscarPorId(clienteId);
    }
}