package com.example.mercado.configuration;

import lombok.Data;

@Data
public class FornecedorFinanceiroRequest {

    private String cnpj;
    private String nomeFornecedor;

    private String identificador;
}
