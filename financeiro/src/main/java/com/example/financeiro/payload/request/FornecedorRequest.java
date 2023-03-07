package com.example.financeiro.payload.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
public class FornecedorRequest {

    private String cnpj;
    private String nomeFornecedor;

    private String identificador;
}