package com.example.mercado.fornecimento.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Funcionario")
public class Fornecedor {
    @Id
    private String cnpj;

    private String nome;

    private String identificador;

}