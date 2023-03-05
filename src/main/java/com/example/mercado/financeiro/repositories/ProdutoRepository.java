package com.example.mercado.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mercado.financeiro.entity.Produto;

import java.util.Optional;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
    Optional<Produto> findByIdentificador(String identificador);
}