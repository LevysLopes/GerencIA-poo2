package com.seuprojeto.gerencia.controller;

import com.seuprojeto.gerencia.model.Produto;
import com.seuprojeto.gerencia.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Defesa Arquitetural (MVC): O Controller é a camada de visualização/interação da nossa API[cite: 1145, 1147]. Ele recebe as requisições HTTP e delega o trabalho pesado para o Service.
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    // Defesa POO (Injeção de Dependência): Recebemos o Service via construtor. O Controller não precisa saber COMO o Service funciona internamente (Abstração), apenas sabe que pode usá-lo.
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto); // [cite: 1474, 1475, 1476]
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarTodos(); // [cite: 1368, 1369, 1370]
    }

    // Endpoint específico para o requisito de alertas de estoque baixo
    @GetMapping("/alerta-estoque")
    public List<Produto> verificarEstoque() {
        return produtoService.verificarEstoqueBaixo();
    }
}