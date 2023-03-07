package com.example.mercado.fornecimento.client.payload.request;

import lombok.Data;

@Data
public class FornecedorFinanceiroRequest {

    private String cnpj;
    private String nomeFornecedor;

    private String identificador;
}