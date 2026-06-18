package com.seuprojeto.gerencia.controller;

import com.seuprojeto.gerencia.model.Produto;
import com.seuprojeto.gerencia.model.Venda;
import com.seuprojeto.gerencia.service.ProdutoService;
import com.seuprojeto.gerencia.service.VendaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final ProdutoService produtoService;
    private final VendaService vendaService;

    // Injetamos os dois serviços para puxar dados de produtos e vendas
    public RelatorioController(ProdutoService produtoService, VendaService vendaService) {
        this.produtoService = produtoService;
        this.vendaService = vendaService;
    }

    @GetMapping("/estoque")
    public List<Map<String, Object>> relatorioEstoque() {
        List<Produto> produtos = produtoService.listarTodos();
        List<Map<String, Object>> relatorio = new ArrayList<>();
       
        for (Produto p : produtos) {
            // LinkedHashMap garante que a ordem inserida aqui será a mesma do JSON final
            Map<String, Object> linha = new LinkedHashMap<>();
            linha.put("id", p.getId());
            linha.put("produto", p.getNome());
            linha.put("estoque", p.getEstoque());
            linha.put("status", p.getEstoque() > p.getNivelMinimo() ? "OK" : "Baixo");
            relatorio.add(linha);
        }
        return relatorio;
    }

    @GetMapping("/vendas")
    public List<Map<String, Object>> relatorioVendas() {
        List<Venda> vendas = vendaService.listarTodas();
        List<Map<String, Object>> relatorio = new ArrayList<>();
       
        for (Venda v : vendas) {
            Map<String, Object> linha = new LinkedHashMap<>();
            linha.put("data", v.getData() != null ? v.getData().toString() : "-");
            linha.put("produtoId", v.getProdutoId());
            
            // CORRIGIDO: Agora usa getQuantidade() para a venda
            linha.put("quantidade", v.getQuantidade());
           
            // Caso sua classe Venda não tenha getValorTotal(), você pode remover esta linha ou adaptar
            linha.put("total", v.getValorTotal() != null ? "R$ " + v.getValorTotal() : "-");
            relatorio.add(linha);
        }
        return relatorio;
    }

    @GetMapping("/alertas")
    public List<Map<String, Object>> relatorioAlertas() {
        // Usa aquele seu método incrível do ProdutoService
        List<Produto> alertas = produtoService.verificarEstoqueBaixo();
        List<Map<String, Object>> relatorio = new ArrayList<>();
       
        for (Produto p : alertas) {
            Map<String, Object> linha = new LinkedHashMap<>();
            linha.put("id", p.getId());
            linha.put("produto", p.getNome());
            linha.put("estoqueAtual", p.getEstoque());
            linha.put("nivelMinimo", p.getNivelMinimo());
            relatorio.add(linha);
        }
        return relatorio;
    }
}

