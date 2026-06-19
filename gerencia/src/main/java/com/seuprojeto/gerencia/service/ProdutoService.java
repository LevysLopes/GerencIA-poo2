package com.seuprojeto.gerencia.service;

import com.seuprojeto.gerencia.model.Produto;
import com.seuprojeto.gerencia.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto(Produto produto) {
        if (produto.getEstoque() != null && produto.getEstoque() < 0) {
            throw new RuntimeException("O estoque inicial não pode ser negativo.");
        }
        if (produto.getPreco() != null && produto.getPreco() < 0) {
            throw new RuntimeException("O preço não pode ser negativo.");
        }
        return produtoRepository.save(produto); 
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public List<Produto> verificarEstoqueBaixo() {
        List<Produto> todosProdutos = produtoRepository.findAll();
        return todosProdutos.stream()
                .filter(p -> p.getEstoque() != null && p.getNivelMinimo() != null && p.getEstoque() <= p.getNivelMinimo())
                .collect(Collectors.toList());
    }

    public void atualizarEstoque(Long id, Integer quantidadeVendida) {
        if (quantidadeVendida == null || quantidadeVendida <= 0) {
            throw new RuntimeException("Quantidade de venda inválida.");
        }
        Produto produto = buscarPorId(id);
        if (produto.getEstoque() == null || produto.getEstoque() < quantidadeVendida) {
            throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
        }
        produto.setEstoque(produto.getEstoque() - quantidadeVendida);
        produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }
}