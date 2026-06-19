package com.seuprojeto.gerencia.service;

import com.seuprojeto.gerencia.dto.LoginRequest;
import com.seuprojeto.gerencia.dto.RegistroRequest;
import com.seuprojeto.gerencia.exception.RegraNegocioException;
import com.seuprojeto.gerencia.model.Comerciante;
import com.seuprojeto.gerencia.repository.ComercianteRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final ComercianteRepository comercianteRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(ComercianteRepository comercianteRepository) {
        this.comercianteRepository = comercianteRepository;
    }

    public void registrar(RegistroRequest request) {
        if (comercianteRepository.existsByEmail(request.getEmail())) {
            throw new RegraNegocioException("Ja existe um usuario cadastrado com este e-mail.");
        }

        Comerciante comerciante = new Comerciante();
        comerciante.setNome(request.getNome());
        comerciante.setEmail(request.getEmail());
        comerciante.setSenha(passwordEncoder.encode(request.getSenha()));
        comercianteRepository.save(comerciante);
    }

    public boolean autenticar(LoginRequest request) {
        return comercianteRepository.findByEmail(request.getEmail())
                .map(comerciante -> passwordEncoder.matches(request.getSenha(), comerciante.getSenha()))
                .orElse(false);
    }
}
