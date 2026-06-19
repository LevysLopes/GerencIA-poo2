package com.seuprojeto.gerencia.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProdutoRequest {

    @NotBlank(message = "O nome do produto e obrigatorio.")
    private String nome;

    private String codigoBarras;

    @NotNull(message = "O preco e obrigatorio.")
    @Positive(message = "O preco deve ser maior que zero.")
    private Double preco;

    @NotNull(message = "O estoque e obrigatorio.")
    @PositiveOrZero(message = "O estoque nao pode ser negativo.")
    private Integer estoque;

    @NotNull(message = "O nivel minimo e obrigatorio.")
    @Min(value = 0, message = "O nivel minimo nao pode ser negativo.")
    private Integer nivelMinimo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(Integer nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }
}
