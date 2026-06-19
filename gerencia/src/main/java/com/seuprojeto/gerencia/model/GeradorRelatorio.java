package com.seuprojeto.gerencia.model;

import java.util.Map;

public interface GeradorRelatorio {
    String getTipoRelatorio(); 
    Map<String, Object> gerarDados();
}