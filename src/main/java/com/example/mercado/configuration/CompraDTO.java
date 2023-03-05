package com.example.mercado.configuration;

import com.example.mercado.entity.Cliente;
import com.example.mercado.entity.Compra;
import com.example.mercado.entity.Funcionario;
import com.example.mercado.entity.Produto;
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
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {
    private String idCompra;
    private LocalDateTime dataCompra;
    private Funcionario funcionario;
    private Cliente cliente;
    private List<Produto> produtosCompradosList;

    public CompraDTO of(Compra compra){
        return CompraDTO.builder()
                .idCompra(compra.getIdCompra())
                .dataCompra(compra.getDataCompra())
                .funcionario(compra.getFuncionario())
                .cliente(compra.getCliente())
                .produtosCompradosList(compra.getProdutosCompradosList())
                .build();
    }

    public Compra toEntity(){
        return Compra.builder()
                .idCompra(idCompra)
                .dataCompra(dataCompra)
                .funcionario(funcionario)
                .cliente(cliente)
                .produtosCompradosList(produtosCompradosList)
                .build();
    }
}
