package com.seuprojeto.gerencia.service;

import com.seuprojeto.gerencia.model.ItemVenda;
import com.seuprojeto.gerencia.model.Venda;
import com.seuprojeto.gerencia.repository.VendaRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ProdutoService produtoService;

    public VendaService(VendaRepository vendaRepository, ProdutoService produtoService) {
        this.vendaRepository = vendaRepository;
        this.produtoService = produtoService;
    }

    // Defesa SOLID (SRP - Princípio da Responsabilidade Única): A classe VendaService foca estritamente em registrar a venda[cite: 779, 780]. A complexidade de dar baixa no estoque é delegada ao ProdutoService.
    @Transactional
    public Venda realizarVenda(Venda venda, java.util.List<ItemVenda> itens) {
        double valorTotal = 0.0;
        
        for (ItemVenda item : itens) {
            // Requisito: Baixa de estoque automática
            produtoService.atualizarEstoque(item.getProduto().getId(), item.getQuantidadeVendida());
            
            // Calcula o subtotal do item
            valorTotal += item.getQuantidadeVendida() * item.getPrecoUnitario();
        }
        
        venda.setValorTotal(valorTotal);
        venda.setDataVenda(new java.util.Date());
        
        return vendaRepository.save(venda);
    }
}