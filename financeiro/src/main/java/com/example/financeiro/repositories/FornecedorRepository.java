package com.example.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.financeiro.entity.Fornecedor;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Optional<Fornecedor> findByIdentificador(String identificador);
}