package com.example.mercado.compra.services;

import com.example.mercado.compra.entity.Produto;
import com.example.mercado.compra.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateProdutoService {
    private final ProdutoRepository produtoRepository;
    public Produto execute(Produto produto){
        produto.setIdProduto(UUID.randomUUID().toString());
        log.info("Produto de ID{}", produto.getIdProduto());
        return produtoRepository.findById(produto.getIdProduto()).orElse(produtoRepository.save(produto));
    }

    public Optional<Produto> getById(String id) {
        var produto = produtoRepository.findById(id);
        return produto;
    }
}
