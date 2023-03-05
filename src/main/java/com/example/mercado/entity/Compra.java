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
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @CreatedDate
    private LocalDateTime dataCompra;
    @OneToMany(mappedBy = "idProduto")
    private List<Produto> produtosCompradosList;
}
