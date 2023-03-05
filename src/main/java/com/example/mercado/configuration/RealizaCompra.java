package com.example.mercado.configuration;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RealizaCompra {
    @NotNull
    private FornecedorFinanceiroRequest fornecedor;

    @NotNull
    private List<ItemRequest> items;
}
