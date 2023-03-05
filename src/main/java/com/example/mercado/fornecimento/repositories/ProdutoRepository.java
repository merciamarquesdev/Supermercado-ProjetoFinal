package com.example.mercado.fornecimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mercado.fornecimento.entity.Produto;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    Optional<Produto> findByNomeAndMarcaAndQuantidade(String nome, String marca, long quantidade);
}