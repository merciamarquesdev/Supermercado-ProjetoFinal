package com.example.mercado.compra.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idProduto;
    private String nome;
    private String marca;
    private Integer quantidade;
    private Double precoDeVenda;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id_fornecedor")
    private Fornecedor fornecedor;
}
