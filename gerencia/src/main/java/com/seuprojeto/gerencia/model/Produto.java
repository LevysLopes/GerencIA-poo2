package com.seuprojeto.gerencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String codigoBarras;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer estoque;

    @Column(nullable = false)
    private Integer nivelMinimo;

    public boolean estaComEstoqueBaixo() {
        int estoqueAtual = estoque != null ? estoque : 0;
        int minimo = nivelMinimo != null ? nivelMinimo : 0;
        return estoqueAtual <= minimo;
    }

    public void baixarEstoque(int quantidadeVendida) {
        if (quantidadeVendida <= 0) {
            throw new IllegalArgumentException("A quantidade vendida deve ser maior que zero.");
        }

        int estoqueAtual = estoque != null ? estoque : 0;
        if (estoqueAtual < quantidadeVendida) {
            throw new IllegalArgumentException("Estoque insuficiente para o produto: " + nome);
        }

        estoque = estoqueAtual - quantidadeVendida;
    }

    public Double calcularValorTotal(int quantidadeVendida) {
        double precoAtual = preco != null ? preco : 0.0;
        return precoAtual * quantidadeVendida;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(String codigoBarras) { this.codigoBarras = codigoBarras; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }

    public Integer getNivelMinimo() { return nivelMinimo; }
    public void setNivelMinimo(Integer nivelMinimo) { this.nivelMinimo = nivelMinimo; }
}
