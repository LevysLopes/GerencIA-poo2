package com.seuprojeto.gerencia.controller;

import com.seuprojeto.gerencia.model.Produto;
import com.seuprojeto.gerencia.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }

    @GetMapping("/alerta-estoque")
    public List<Produto> verificarEstoque() {
        return produtoService.verificarEstoqueBaixo();
    }
}