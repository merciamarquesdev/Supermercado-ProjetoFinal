package com.example.mercado.fornecimento.client.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RealizarPagamentoFinanceiro {
    @NotNull
    private FornecedorFinanceiroRequest fornecedor;

    @NotNull
    private List<ItemRequest> items;
}