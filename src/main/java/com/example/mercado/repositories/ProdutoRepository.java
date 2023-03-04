package com.example.mercado.repositories;

import com.example.mercado.entity.Cliente;
import com.example.mercado.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    Optional<Produto> findByNomeAndMarcaAndQuantidade(String nome, String marca, Integer quantidade);
}
