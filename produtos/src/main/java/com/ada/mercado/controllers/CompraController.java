package com.ada.mercado.controllers;

import com.ada.mercado.Compra;
import com.ada.mercado.DTOs.CompraDTO;
import com.ada.mercado.producer.CompraProducer;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/Compra")
@AllArgsConstructor
public class CompraController {
    private final CompraProducer compraProducer;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendMessage(@RequestBody CompraDTO compraDTO){
        var id = UUID.randomUUID().toString();

        var message = Compra.newBuilder().setIdCompra(id).setCpf(compraDTO.getCpf())
                .setProdutosCompradosList(compraDTO.getProdutosCompradosList().stream().map(p -> (CharSequence) p).collect(Collectors.toList()))
                .build();

        compraProducer.sendMessage(message);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
