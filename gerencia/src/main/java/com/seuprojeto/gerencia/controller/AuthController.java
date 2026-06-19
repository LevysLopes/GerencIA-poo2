package com.seuprojeto.gerencia.controller;

import com.seuprojeto.gerencia.dto.LoginRequest;
import com.seuprojeto.gerencia.dto.RegistroRequest;
import com.seuprojeto.gerencia.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginData) {
        if (authService.autenticar(loginData)) {
            return ResponseEntity.ok(Map.of("mensagem", "Login realizado com sucesso."));
        }
        return ResponseEntity.status(401).body(Map.of("erro", "Credenciais invalidas."));
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroRequest novo) {
        authService.registrar(novo);
        return ResponseEntity.ok(Map.of("mensagem", "Usuario registrado com sucesso."));
    }
}
