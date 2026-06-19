package com.seuprojeto.gerencia.controller;

import com.seuprojeto.gerencia.model.Venda;
import com.seuprojeto.gerencia.service.VendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public Venda registrar(@RequestBody Venda venda) {
        return vendaService.realizarVenda(venda); 
    }

    @GetMapping
    public List<Venda> listar() {
        return vendaService.listarTodas();
    }
}