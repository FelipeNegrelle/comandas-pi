package com.mith.inn_orders_generator.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENTES")
public class Cliente extends AbstractEntity<Integer> {

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String doc;

    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_quarto_fk")
    private Quarto quarto;

    public String getNome() {
        return nome;
    }

    public String getDoc() {
        return doc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
