package com.example.mercado.financeiro.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String identificador;
}