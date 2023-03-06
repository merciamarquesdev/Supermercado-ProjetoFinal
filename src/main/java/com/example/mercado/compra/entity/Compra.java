package com.example.mercado.compra.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glassfish.jersey.spi.Contract;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
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
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @OneToMany(mappedBy = "nome")
    private List<Produto> produtosCompradosList;
}
