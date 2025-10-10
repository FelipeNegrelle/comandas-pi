package com.mith.inn_orders_generator.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "COMANDAS")
public class Comanda extends AbstractEntity<Long> {

    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_cliente_responsavel_fk")
    private Cliente responsavel;

    @OneToMany(mappedBy = "comanda")
    private List<Item> itens;

    @Column(name = "esta_fechada")
    private boolean estaFechada;

    private Double total;

    public void setData(Date data) {
        this.data = data;
    }

    public void setResponsavel(Cliente responsavel) {
        this.responsavel = responsavel;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void setEstaFechada(boolean estaFechada) {
        this.estaFechada = estaFechada;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public Cliente getResponsavel() {
        return responsavel;
    }

    public List<Item> getItens() {
        return itens;
    }

    public boolean isEstaFechada() {
        return estaFechada;
    }

    public Double getTotal() {
        return total;
    }
}
