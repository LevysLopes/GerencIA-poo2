package com.seuprojeto.gerencia.service;

import com.seuprojeto.gerencia.model.GeradorRelatorio;
import com.seuprojeto.gerencia.model.Produto;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioEstoqueService implements GeradorRelatorio {

    private final ProdutoService produtoService;

    public RelatorioEstoqueService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Override
    public String getTipoRelatorio() {
        return "ESTOQUE";
    }

    @Override
    public Map<String, Object> gerarDados() {
        List<Produto> todos = produtoService.listarTodos();
        List<Produto> emAlerta = produtoService.verificarEstoqueBaixo();

        Map<String, Object> dados = new HashMap<>();
        dados.put("totalProdutosCadastrados", todos.size());
        dados.put("produtosEmAlerta", emAlerta.size());
        dados.put("detalhesAlerta", emAlerta);
        
        return dados;
    }
}