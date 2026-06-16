package com.seuprojeto.gerencia.repository;

import com.seuprojeto.gerencia.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Defesa POO (Herança): A interface ProdutoRepository herda (extends) todos os métodos prontos do JpaRepository (save, findAll, deleteById, etc)[cite: 1464, 1465]. Isso evita a repetição de código SQL manual.
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}