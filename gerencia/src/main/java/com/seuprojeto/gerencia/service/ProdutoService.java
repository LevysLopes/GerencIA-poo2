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
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public List<Produto> verificarEstoqueBaixo() {
        List<Produto> todosProdutos = produtoRepository.findAll();
        return todosProdutos.stream()
                .filter(p -> p.getEstoque() <= p.getNivelMinimo())
                .collect(Collectors.toList());
    }

    public void atualizarEstoque(Long produtoId, int quantidadeVendida) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado no sistema."));
       
        if (produto.getEstoque() < quantidadeVendida) {
            throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
        }
       
        produto.setEstoque(produto.getEstoque() - quantidadeVendida);
        produtoRepository.save(produto);
    }

    // --- NOVO: Permite ao VendaService puxar o Produto pelo ID para ler o preço ---
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }
}

