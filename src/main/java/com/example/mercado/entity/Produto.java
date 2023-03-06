package com.example.mercado.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idProduto;
    private String nome;
    private Integer quantidade;
    private Double preco;
}
