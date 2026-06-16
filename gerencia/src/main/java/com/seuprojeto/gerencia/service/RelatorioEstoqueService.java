package com.seuprojeto.gerencia.service;

import com.seuprojeto.gerencia.model.GeradorRelatorio;
import org.springframework.stereotype.Service;

@Service
public class RelatorioEstoqueService implements GeradorRelatorio {

    @Override
    public void gerarRelatorio() {
        System.out.println("Gerando relatório de ESTOQUE crítico e produtos disponíveis...");
    }
}