package com.seuprojeto.gerencia.repository;

import com.seuprojeto.gerencia.model.Comerciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercianteRepository extends JpaRepository<Comerciante, Long> {
    // O Spring Data JPA cria a consulta automaticamente baseada no nome do método
    Comerciante findByEmailAndSenha(String email, String senha);
}