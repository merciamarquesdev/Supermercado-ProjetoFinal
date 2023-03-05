package com.example.mercado.financeiro.payload;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class HelloResponse {
    private String text;
}