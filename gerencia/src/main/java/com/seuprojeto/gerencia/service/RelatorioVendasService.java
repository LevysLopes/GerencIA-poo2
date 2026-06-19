package com.seuprojeto.gerencia.service;

import com.seuprojeto.gerencia.model.GeradorRelatorio;
import com.seuprojeto.gerencia.model.Venda;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioVendasService implements GeradorRelatorio {

    private final VendaService vendaService;

    public RelatorioVendasService(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @Override
    public String getTipoRelatorio() {
        return "VENDAS";
    }

    @Override
    public Map<String, Object> gerarDados() {
        List<Venda> vendas = vendaService.listarTodas();
        double faturamentoTotal = vendas.stream().mapToDouble(Venda::getValorTotal).sum();

        Map<String, Object> dados = new HashMap<>();
        dados.put("totalVendasRealizadas", vendas.size());
        dados.put("faturamentoTotal", faturamentoTotal);
        
        return dados;
    }
}