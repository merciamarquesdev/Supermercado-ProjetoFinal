package com.example.mercado.fornecimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mercado.fornecimento.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
