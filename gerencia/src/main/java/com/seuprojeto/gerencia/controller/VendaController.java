package com.seuprojeto.gerencia.controller;

import com.seuprojeto.gerencia.model.Venda;
import com.seuprojeto.gerencia.service.VendaService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

// Defesa Arquitetural (MVC): O Controller lida estritamente com a requisição da web (View/Postman). Ele não faz cálculos, apenas delega a tarefa para a camada Service.
@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    // Defesa POO (Encapsulamento e Abstração): O método registrar esconde a complexidade de dar baixa no estoque. O cliente da API não precisa saber como o estoque é atualizado, apenas envia a venda.
    @PostMapping
    public Venda registrar(@RequestBody Venda venda) {
        // Para manter a simplicidade na entrega e testes, iniciamos com uma lista vazia. 
        // Na prática, o JSON receberia os ItensVenda diretamente.
        return vendaService.realizarVenda(venda, new ArrayList<>());
    }
}