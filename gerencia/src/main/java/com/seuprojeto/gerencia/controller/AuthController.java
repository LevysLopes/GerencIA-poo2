package com.seuprojeto.gerencia.controller;

import com.seuprojeto.gerencia.model.Comerciante;
import com.seuprojeto.gerencia.repository.ComercianteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final ComercianteRepository repository;

    // Construtor para injeção de dependência (melhor prática)
    public AuthController(ComercianteRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Comerciante loginData) {
        Comerciante c = repository.findByEmailAndSenha(loginData.getEmail(), loginData.getSenha());
        if (c != null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Comerciante novo) {
        // Dica: Aqui você poderia verificar se o e-mail já existe antes de salvar
        repository.save(novo);
        return ResponseEntity.ok().build();
    }
}