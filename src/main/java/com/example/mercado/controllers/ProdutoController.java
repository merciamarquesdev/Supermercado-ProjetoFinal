package com.example.mercado.controllers;

import com.example.mercado.entity.Produto;
import com.example.mercado.services.CreateProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {
    private final CreateProdutoService createProdutoService;
    @PostMapping(path = "")
    public void addProduto(@RequestBody Produto produto){
        createProdutoService.execute(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable String id){
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID não informado!");
        }
        Produto produto = createProdutoService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel localizar um produto com o id informado!"));
        return ResponseEntity.ok(produto);
    }

}
