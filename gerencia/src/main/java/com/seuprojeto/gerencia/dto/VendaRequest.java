package com.seuprojeto.gerencia.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VendaRequest {

    @NotNull(message = "O produto e obrigatorio.")
    private Long produtoId;

    @NotNull(message = "A quantidade e obrigatoria.")
    @Positive(message = "A quantidade deve ser maior que zero.")
    private Integer quantidade;

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
