package com.example.mercado.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@Table(name="Compra")
public class Compra {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idCompra;
    @CreatedDate
    private LocalDateTime dataCompra;
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "idProduto")
    private List<Produto> produtosCompradosList;
}
