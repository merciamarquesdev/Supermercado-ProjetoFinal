package com.example.mercado.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name="Cliente")
public class Cliente {
    @Id
    private String idCliente;
    private String cpfCliente;
    private String nomeCliente;
    @OneToMany(mappedBy = "idCompra")
    private List<Compra> compras;

}
