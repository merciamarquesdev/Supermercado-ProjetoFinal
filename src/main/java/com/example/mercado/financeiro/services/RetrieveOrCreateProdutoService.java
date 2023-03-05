package com.example.mercado.financeiro.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.mercado.financeiro.entity.Produto;
import com.example.mercado.financeiro.repositories.ProdutoRepository;

@Service
@RequiredArgsConstructor
public class RetrieveOrCreateProdutoService {
    private final ProdutoRepository produtoRepository;
    public Produto execute(Produto produto){
        return produtoRepository.findByIdentificador(produto.getIdentificador())
                .orElse(produtoRepository.save(produto));
    }
}