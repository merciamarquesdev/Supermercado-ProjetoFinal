package com.example.mercado.compra.entity;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="Fornecedor")
public class Fornecedor {
    @Id
    private String idFornecedor;
    private String cnpj;
}
