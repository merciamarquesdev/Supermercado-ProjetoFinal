package com.example.mercado.fornecimento.services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.mercado.fornecimento.entity.ItemPedido;
import com.example.mercado.fornecimento.entity.ItemPedidoComposedKey;
import com.example.mercado.fornecimento.entity.Pedido;
import com.example.mercado.fornecimento.repositories.ItemPedidoRepository;
import com.example.mercado.fornecimento.repositories.PedidoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreatePedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    public Pedido execute(Pedido pedido, List<ItemPedido> itemPedidos){
        Pedido savedPedido= pedidoRepository.save(pedido);
        itemPedidos
                .forEach(itemPedido ->
                        itemPedido.setItemPedidoComposedKey
                                (new ItemPedidoComposedKey(savedPedido.getId(),itemPedido.getProduto().getId())));
        itemPedidoRepository.saveAll(itemPedidos);
        savedPedido.setItemPedidoList(itemPedidos);
        return savedPedido;
    }
}