package com.seuprojeto.gerencia.service;

import com.seuprojeto.gerencia.model.Venda;
import com.seuprojeto.gerencia.model.ItemVenda;
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
        double valorTotal = 0.0;

        if (venda.getItens() == null || venda.getItens().isEmpty()) {
            throw new RuntimeException("A venda deve conter pelo menos um item.");
        }

        for (ItemVenda item : venda.getItens()) {
            if (item.getProduto() == null || item.getProduto().getId() == null) {
                throw new RuntimeException("Produto não identificado no item da venda.");
            }

            produtoService.atualizarEstoque(item.getProduto().getId(), item.getQuantidade());

            Produto produto = produtoService.buscarPorId(item.getProduto().getId());

            item.setPrecoUnitario(produto.getPreco());
            item.setVenda(venda); 

            valorTotal += (produto.getPreco() * item.getQuantidade());
        }

        venda.setValorTotal(valorTotal);
        venda.setData(new Date());

        return vendaRepository.save(venda);
    }
}