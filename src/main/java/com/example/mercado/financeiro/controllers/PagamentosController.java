package com.example.mercado.financeiro.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.mercado.financeiro.payload.request.PagamentoFornecedorRequest;
import com.example.mercado.financeiro.payload.response.RelatorioFornecedor;
import com.example.mercado.financeiro.services.SalvarPagamentoService;
import com.example.mercado.financeiro.services.SomaPedidosPorFornecedorService;

@RestController
@RequestMapping("/pagamento")
@RequiredArgsConstructor
@Slf4j
public class PagamentosController {

    private final SalvarPagamentoService salvarPagamentoService;
    private final SomaPedidosPorFornecedorService somaPedidosPorFornecedorService;
    @PostMapping(path = "/fornecedor")
    @ResponseStatus(HttpStatus.CREATED)
    public void realizarPagamentoFornecedor(@RequestBody PagamentoFornecedorRequest pagamentoFornecedorRequest){
        log.info("Requisição de pagamento recebido {}",pagamentoFornecedorRequest);
        salvarPagamentoService.execute(pagamentoFornecedorRequest);
    }

    @GetMapping(path = "/relatorio/{idFornecedor}")
    public RelatorioFornecedor getRelatorioFornecedor(@PathVariable String idFornecedor){
        return somaPedidosPorFornecedorService.execute(idFornecedor);
    }
}