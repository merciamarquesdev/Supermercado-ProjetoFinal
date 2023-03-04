package com.example.mercado.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Funcionario")
public class Funcionario {
    @Id
    private String idFuncionario;
    private String cpfFuncionario;
    private String nomeFuncionario;
}
