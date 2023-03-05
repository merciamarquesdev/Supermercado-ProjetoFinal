package com.example.mercado.compra.repositories;

import com.example.mercado.compra.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    Optional<Produto> findByNomeAndMarca(String nome, String marca);
}
