package com.seuprojeto.gerencia.service;

import com.seuprojeto.gerencia.model.GeradorRelatorio;
import org.springframework.stereotype.Service;

// Defesa POO (Polimorfismo e SOLID - OCP): Ao implementar a interface GeradorRelatorio, esta classe assume uma forma específica. Podemos adicionar relatórios infinitos no futuro sem alterar a estrutura base do sistema.
@Service
public class RelatorioVendasService implements GeradorRelatorio {

    @Override
    public void gerarRelatorio() {
        // Aqui entraria a biblioteca de geração de PDF, por exemplo.
        System.out.println("Gerando relatório de VENDAS para o painel do comerciante...");
    }
}