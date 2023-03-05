package com.example.mercado.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mercado.financeiro.entity.Fornecedor;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Optional<Fornecedor> findByIdentificador(String identificador);
}