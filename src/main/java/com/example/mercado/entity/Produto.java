package com.example.mercado.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="Produto")
public class Produto {
    @Id
    private String idProduto;
    private String nome;
    private LocalDate dataDeValidade;
    private Double precoDeCompra;
    private Double precoDeVenda;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id_fornecedor")
    private Fornecedor fornecedor;
}
