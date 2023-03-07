package com.example.mercado.compra.controllers;

import com.example.mercado.compra.entity.Funcionario;
import com.example.mercado.compra.services.CreateFuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioClontroller {
    private final CreateFuncionarioService createFuncionarioService;
    @PostMapping(path = "")
    public void addFuncionario(@RequestBody Funcionario funcionario){
        createFuncionarioService.execute(funcionario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable String id){
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID não informado!");
        }
        Funcionario funcionario = createFuncionarioService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel localizar um funcionario com o id informado!"));
        return ResponseEntity.ok(funcionario);
    }
}
