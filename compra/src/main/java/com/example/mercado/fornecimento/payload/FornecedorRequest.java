package com.example.mercado.fornecimento.payload;

import lombok.Data;

@Data
public class FornecedorRequest {
    private String identificador;

    private String cnpj;
    private String nome;
}