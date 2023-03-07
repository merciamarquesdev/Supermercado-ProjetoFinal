package com.example.mercado.configuration;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
public class CompraDTO {
    private String idCompra;
    private String cpf;
    private List<String> produtosCompradosList;


    //    public CompraDTO of(Compra compra){
//        final ProdutoRepository produtoRepository = null;
//        List<String> produtosComprados = null;
//        produtosComprados.add(compra.getProdutosCompradosList().forEach(produto -> produto.getNome()));
//        return CompraDTO.builder()
//                .idCompra(compra.getIdCompra())
//                .dataCompra(compra.getDataCompra())
//                .funcionario(compra.getFuncionario())
//                .cliente(compra.getCliente())
//                .produtosCompradosList(produtosComprados)
//                .build();
//    }
//
//    public Compra toEntity(){
//        return Compra.builder()
//                .idCompra(idCompra)
//                .dataCompra(dataCompra)
//                .funcionario(funcionario)
//                .cliente(cliente)
//                .produtosCompradosList(produtosCompradosList)
//                .build();
//    }
}
