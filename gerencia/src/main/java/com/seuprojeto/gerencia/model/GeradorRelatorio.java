package com.seuprojeto.gerencia.model;

// Defesa POO (Polimorfismo e SOLID - OCP): O Princípio Aberto-Fechado (OCP) nos diz que o sistema deve ser aberto para extensão, mas fechado para modificação. Usando esta interface, podemos criar múltiplos relatórios diferentes sem alterar o código existente.
public interface GeradorRelatorio {
    void gerarRelatorio();
}