package com.example.mercado.fornecimento.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mercado.fornecimento.entity.Fornecedor;

public interface FornecedorRepository  extends JpaRepository<Fornecedor, String> {
}