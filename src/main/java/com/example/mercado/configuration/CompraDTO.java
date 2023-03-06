package com.example.mercado.configuration;

import com.ada.mercado.Cliente;
import com.ada.mercado.Funcionario;
import com.example.mercado.entity.Compra;
import com.example.mercado.entity.Produto;
import com.example.mercado.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.java.ClobTypeDescriptor;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
public class CompraDTO {
    private String idCompra;
    private Funcionario funcionario;
    private com.ada.mercado.Cliente cliente;
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
