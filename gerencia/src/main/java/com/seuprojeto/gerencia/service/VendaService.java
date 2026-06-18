package com.seuprojeto.gerencia.service;

import com.seuprojeto.gerencia.model.Venda;
import com.seuprojeto.gerencia.model.Produto;
import com.seuprojeto.gerencia.repository.VendaRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Date;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ProdutoService produtoService;

    public VendaService(VendaRepository vendaRepository, ProdutoService produtoService) {
        this.vendaRepository = vendaRepository;
        this.produtoService = produtoService;
    }

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    @Transactional
    public Venda realizarVenda(Venda venda) {
        // Baixa de estoque automática
        produtoService.atualizarEstoque(venda.getProdutoId(), venda.getQuantidade());
       
        // --- NOVO: Cálculo do Valor Total da Venda ---
        Produto produto = produtoService.buscarPorId(venda.getProdutoId());
        Double precoDoProduto = (produto.getPreco() != null) ? produto.getPreco() : 0.0;
        venda.setValorTotal(precoDoProduto * venda.getQuantidade());
       
        // Registra a data
        venda.setData(new Date());
       
        return vendaRepository.save(venda);
    }
}

