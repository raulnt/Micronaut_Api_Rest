package com.exemplo.leilao.entidades;

import java.util.List;

public class LeilaoDetalhado {

    private Leilao leilao;
    private List<Produto> produtos;
    private int quantidadeProdutos;

    // Getters e setters

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }
}
