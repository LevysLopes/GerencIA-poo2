package com.seuprojeto.gerencia.repository;

import com.seuprojeto.gerencia.model.Comerciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComercianteRepository extends JpaRepository<Comerciante, Long> {

    Optional<Comerciante> findByEmail(String email);

    boolean existsByEmail(String email);
}
