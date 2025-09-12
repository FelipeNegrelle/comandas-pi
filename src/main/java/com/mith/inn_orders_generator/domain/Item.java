package com.mith.inn_orders_generator.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ITENS")
public class Item extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "id_comanda_fk")
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "id_quarto_fk")
    private Quarto quarto;

    @ManyToOne
    @JoinColumn(name = "id_produto_fk")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_cliente_fk")
    private Cliente cliente;

    private Double valor;

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Produto getProduto() {
        return produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getValor() {
        return valor;
    }
}
