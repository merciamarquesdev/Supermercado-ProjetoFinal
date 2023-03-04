package com.example.mercado.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="Compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCompra;
    @CreatedDate
    private LocalDateTime dataCompra;
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    @OneToMany(mappedBy = "idProduto")
    private List<Produto> produtosCompradosList;
}
