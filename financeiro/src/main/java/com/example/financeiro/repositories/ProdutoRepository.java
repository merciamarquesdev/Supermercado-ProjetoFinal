package com.example.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.financeiro.entity.Produto;

import java.util.Optional;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
    Optional<Produto> findByIdentificador(String identificador);
}