package com.example.mercado.repositories;

import com.example.mercado.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
}
