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

    private String requerente;

    @Transient
    private String descricao;

    public Item() {}

    public Item(Produto produto) {
        this.produto = produto;
        this.descricao = "Produto: " + produto.getDescr();
        this.valor = produto.getValor();
    }

    public Item(Quarto quarto) {
        this.quarto = quarto;
        this.descricao = quarto.getTipo();
        this.valor = quarto.getValor();
    }

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

    public String getRequerente() {
        return requerente;
    }

    public void setRequerente(String requerente) {
        this.requerente = requerente;
    }

    public String getDescricao() {
        if (descricao != null) {
            return descricao;
        }
        if (produto != null) {
            return "Produto: " + produto.getDescr();
        }
        if (quarto != null) {
            return "Quarto: " + quarto.getTipo();
        }
        return "Item";
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
