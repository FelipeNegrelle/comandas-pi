package com.mith.inn_orders_generator.web.converter;

import com.mith.inn_orders_generator.domain.Quarto;
import com.mith.inn_orders_generator.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuartoConverter implements Converter<String, Quarto> {

    @Autowired
    private QuartoService quartoService;

    @Override
    public Quarto convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        Byte quartoId = Byte.valueOf(id);
        return quartoService.buscarPorId(quartoId);
    }
}
