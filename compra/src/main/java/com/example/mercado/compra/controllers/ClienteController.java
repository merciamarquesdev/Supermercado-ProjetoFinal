package com.example.mercado.compra.controllers;

import com.example.mercado.compra.entity.Cliente;
import com.example.mercado.compra.services.CreateClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {
    private final CreateClienteService createClienteService;
    @PostMapping(path = "")
    public void addCliente(@RequestBody Cliente cliente){
        createClienteService.excute(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable String id){
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID não informado!");
        }
        Cliente cliente = createClienteService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel localizar um cliente com o id informado!"));
        return ResponseEntity.ok(cliente);
    }
}
