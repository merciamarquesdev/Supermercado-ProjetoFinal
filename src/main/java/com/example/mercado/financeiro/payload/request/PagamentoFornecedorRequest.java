package com.example.mercado.financeiro.payload.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PagamentoFornecedorRequest {
    @NotNull
    private FornecedorRequest fornecedor;

    @NotNull
    private List<ItemRequest> items;

}