package com.ada.mercado.DTOs;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProdutoDTO {
    private String idProduto;
    private String nome;
    private Integer quantidade;
    private Double preco;
}
