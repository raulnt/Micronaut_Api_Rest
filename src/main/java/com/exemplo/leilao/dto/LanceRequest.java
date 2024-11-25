package com.exemplo.leilao.dto;

import java.math.BigDecimal;

public class LanceRequest {

    private Long produtoId;
    private Long clienteId;
    private BigDecimal valorLance;

    // Getters e Setters
    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public BigDecimal getValorLance() {
        return valorLance;
    }

    public void setValorLance(BigDecimal valorLance) {
        this.valorLance = valorLance;
    }
}
