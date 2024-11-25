package com.exemplo.leilao.enums;

public enum StatusLeilao {

    EM_ABERTO("Leilão aberto, aguardando início"),
    EM_ANDAMENTO("Leilão em andamento"),
    FINALIZADO("Leilão finalizado");

    private final String descricao;

    // Construtor para atribuir a descrição a cada status
    StatusLeilao(String descricao) {
        this.descricao = descricao;
    }

    // Método para obter a descrição
    public String getDescricao() {
        return descricao;
    }
}
