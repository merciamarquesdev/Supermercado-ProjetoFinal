package com.example.mercado.fornecimento.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.mercado.fornecimento.entity.Produto;
import com.example.mercado.fornecimento.repositories.ProdutoRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateOrRetrieveProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto execute(Produto produto){
        produto.setIdentificador(UUID.randomUUID().toString());
        return produtoRepository.findByNomeAndMarcaAndQuantidade(produto.getNome(), produto.getMarca()
                , produto.getQuantidade()).orElse(produtoRepository.save(produto));
    }

}
