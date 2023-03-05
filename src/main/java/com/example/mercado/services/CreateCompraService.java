package com.example.mercado.services;

import com.example.mercado.entity.Compra;
import com.example.mercado.entity.Produto;
import com.example.mercado.repositories.CompraRepository;
import com.example.mercado.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateCompraService {
    private final CompraRepository compraRepository;

    public Compra execute(Compra compra, List<Produto> produtos){
        Compra savedCompra = compraRepository.save(compra);
        produtos.forEach(produto -> produto.setIdProduto(produto.getIdProduto()));
        produtos.forEach(produto -> produto.setQuantidade(produto.getQuantidade() -1));
        savedCompra.setProdutosCompradosList(produtos);
        return savedCompra;
    }
}
