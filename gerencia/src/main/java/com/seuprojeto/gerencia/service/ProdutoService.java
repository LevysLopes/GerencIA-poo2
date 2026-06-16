package com.seuprojeto.gerencia.service;

import com.seuprojeto.gerencia.model.Produto;
import com.seuprojeto.gerencia.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    // Defesa POO (Encapsulamento e Injeção de Dependência): O repositório é privado. O Spring injeta a dependência no construtor automaticamente, reduzindo o acoplamento.
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

    // Defesa POO (Abstração da Lógica de Negócio): A regra que define se o estoque está baixo fica escondida dentro do Service, respeitando a separação de responsabilidades do padrão MVC[cite: 1145, 1146, 1147].
    public List<Produto> verificarEstoqueBaixo() {
        List<Produto> todosProdutos = produtoRepository.findAll();
        // Filtra e retorna apenas os produtos cuja quantidade atual é menor ou igual ao nível mínimo definido pelo comerciante
        return todosProdutos.stream()
                .filter(p -> p.getQuantidade() <= p.getNivelMinimo())
                .collect(Collectors.toList());
    }

    public void atualizarEstoque(Long produtoId, int quantidadeVendida) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado no sistema."));
        
        if (produto.getQuantidade() < quantidadeVendida) {
            throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
        }
        
        produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
        produtoRepository.save(produto);
    }
}