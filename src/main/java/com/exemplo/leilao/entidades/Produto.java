package com.exemplo.leilao.entidades;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal lanceInicial;

    private BigDecimal lancesAdicionais;  // Pode ser nulo

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLanceInicial() {
        return lanceInicial;
    }

    public void setLanceInicial(BigDecimal lanceInicial) {
        this.lanceInicial = lanceInicial;
    }

    public BigDecimal getLancesAdicionais() {
        return lancesAdicionais;
    }

    public void setLancesAdicionais(BigDecimal lancesAdicionais) {
        this.lancesAdicionais = lancesAdicionais;
    }
}
