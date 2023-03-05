package com.example.mercado.compra.controllers;

import com.example.mercado.compra.entity.Fornecedor;
import com.example.mercado.compra.services.CreateFornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/fornecedor")
@RequiredArgsConstructor
public class FornecedorController {
    private final CreateFornecedorService createFornecedorService;
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFornecedor(@RequestBody Fornecedor fornecedor){
        createFornecedorService.excute(fornecedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable String id){
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID não informado!");
        }
        Fornecedor fornecedor = createFornecedorService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel localizar um fornecedor com o id informado!"));
        return ResponseEntity.ok(fornecedor);
    }

//    private final CreateProdutoService createProdutoService;
//    @PostMapping(path = "/produto")
//    public  void addProduto(@RequestBody Produto produto){
//        createProdutoService.execute(produto);
//    }
//
//    private final CreateClienteService createClienteService;
//    @PostMapping(path = "/cliente")
//    public void addCliente(@RequestBody Cliente cliente){
//        createClienteService.excute(cliente);
//    }
//
//    private final CreateFuncionarioService createFuncionarioService;
//    @PostMapping(path = "/funcionario")
//    public void addFuncionario(@RequestBody Funcionario funcionario){
//        createFuncionarioService.execute(funcionario);
//    }



}
