package com.mith.inn_orders_generator.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUTO")
@Getter
@Setter
public class Produto extends AbstractEntity<Integer> {

    @Column(name = "descricao")
    private String descr;

    @Column(name = "tem_limite")
    private Boolean temLimite;

    @Column(name = "tipo")
    private Character tipo;

    private Integer quantidade;

    @Column(name = "minimo_no_estoque")
    private Integer minNoEstoque;

    private Double valor;

    public String getTipoDesc() {
        if (tipo != null) {
            return tipo.equals('P') ? "Consumível" : "Serviço";
        }

        return "";
    }
}
