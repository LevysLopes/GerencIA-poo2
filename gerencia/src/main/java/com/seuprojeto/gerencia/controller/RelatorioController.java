package com.seuprojeto.gerencia.controller;

import com.seuprojeto.gerencia.model.GeradorRelatorio;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final List<GeradorRelatorio> geradores;

    public RelatorioController(List<GeradorRelatorio> geradores) {
        this.geradores = geradores;
    }

    @GetMapping("/{tipo}")
    public Map<String, Object> obterRelatorio(@PathVariable String tipo) {
        for (GeradorRelatorio gerador : geradores) {
            if (gerador.getTipoRelatorio().equalsIgnoreCase(tipo)) {
                return gerador.gerarDados();
            }
        }
        throw new RuntimeException("Tipo de relatório não encontrado.");
    }
}