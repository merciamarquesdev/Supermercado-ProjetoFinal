package com.example.mercado.compra.entity;

import lombok.*;
import org.glassfish.jersey.spi.Contract;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Compra")
public class Compra {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idCompra;
    @CreatedDate
    private LocalDateTime dataCompra;
    private String cpf;
    @OneToMany(mappedBy = "nome")
    private List<Produto> produtosCompradosList;
}
