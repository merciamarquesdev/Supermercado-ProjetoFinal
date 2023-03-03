package com.example.mercado.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="Cliente")
public class Cliente {
    @Id
    private String idCliente;
    private String cpfCliente;
    private String nomeCliente;

}
