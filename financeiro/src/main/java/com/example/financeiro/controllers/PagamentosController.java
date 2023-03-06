package com.example.financeiro.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.financeiro.payload.request.PagamentoFornecedorRequest;
import com.example.financeiro.payload.response.RelatorioFornecedor;
import com.example.financeiro.services.SalvarPagamentoService;
import com.example.financeiro.services.SomatorioPedidosPorFornecedorService;

@RestController
@RequestMapping("/pagamento")
@RequiredArgsConstructor
@Slf4j
public class PagamentosController {

    private final SalvarPagamentoService salvarPagamentoService;
    private final SomatorioPedidosPorFornecedorService somaPedidosPorFornecedorService;
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