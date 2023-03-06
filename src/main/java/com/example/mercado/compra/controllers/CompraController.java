package com.example.mercado.controllers;

import com.ada.mercado.Compra;
import com.example.mercado.configuration.CompraDTO;
import com.example.mercado.producer.CompraProducer;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/Compra")
@AllArgsConstructor
public class CompraController {
    private final CompraProducer compraProducer;

    public ResponseEntity<Void> sendMessage(@RequestBody CompraDTO compraDTO){
        var id = UUID.randomUUID().toString();

        var message = Compra.newBuilder().setIdCompra(id).setCliente(compraDTO.getCliente())
                .setFuncionario(compraDTO.getFuncionario())
                .setProdutosCompradosList(compraDTO.getProdutosCompradosList().stream().map(p -> (CharSequence) p).collect(Collectors.toList()))
                .build();

        compraProducer.sendMessage(message);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
