package com.mith.inn_orders_generator.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "QUARTOS")
public class Quarto extends AbstractEntity<Byte> {

    private String tipo;

    @OneToMany(mappedBy = "quarto")
    private List<Cliente> hospedes;

    private Double valor;

    @Column(name = "esta_disponivel")
    private boolean eDisponivel;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setHospedes(List<Cliente> hospedes) {
        this.hospedes = hospedes;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void seteDisponivel(boolean eDisponivel) {
        this.eDisponivel = eDisponivel;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Cliente> getHospedes() {
        return hospedes;
    }

    public Double getValor() {
        return valor;
    }

    public boolean iseDisponivel() {
        return eDisponivel;
    }
}
