package com.ada.mercado.controllers;

import com.ada.mercado.DTOs.ProdutoDTO;
import com.ada.mercado.producer.ProdutoProducer;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoProducer produtoProducer;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Void> sendMessage(@RequestBody ProdutoDTO produtoDTO){
        var id = UUID.randomUUID().toString();

        var message = com.ada.mercado.Produto.newBuilder()

                .setIdProduto(id)
                .setNome(produtoDTO.getNome())
                .setQuantidade(produtoDTO.getQuantidade())
                .setPreco(produtoDTO.getPreco())
                .build();
        produtoProducer.sendMessage(message);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
