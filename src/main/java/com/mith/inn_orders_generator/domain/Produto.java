package com.mith.inn_orders_generator.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto extends AbstractEntity<Integer> {

    @Column(name = "descricao")
    private String descr;

    @Column(name = "tem_limite")
    private boolean temLimite;

    private Integer quantidade;

    @Column(name = "minimo_no_estoque")
    private Integer minNoEstoque;

    private Double valor;

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setTemLimite(boolean temLimite) {
        this.temLimite = temLimite;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setMinNoEstoque(Integer minNoEstoque) {
        this.minNoEstoque = minNoEstoque;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescr() {
        return descr;
    }

    public boolean isTemLimite() {
        return temLimite;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Integer getMinNoEstoque() {
        return minNoEstoque;
    }

    public Double getValor() {
        return valor;
    }
}
