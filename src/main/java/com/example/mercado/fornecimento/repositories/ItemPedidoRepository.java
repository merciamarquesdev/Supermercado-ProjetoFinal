package com.example.mercado.fornecimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mercado.fornecimento.entity.ItemPedido;
import com.example.mercado.fornecimento.entity.ItemPedidoComposedKey;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoComposedKey> {
}