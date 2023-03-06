package com.example.financeiro.payload.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProdutoRequest {
    @NotEmpty(message = "Identificador do produto é requerido")
    private String identificador;
    private String nome;
}