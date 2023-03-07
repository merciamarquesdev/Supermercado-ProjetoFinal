package com.example.mercado.consumer;

import com.ada.mercado.Compra;
import com.example.mercado.entity.Produto;
import com.example.mercado.repositories.CompraRepository;
import com.example.mercado.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@Slf4j
@AllArgsConstructor
public class CompraConsumer {
    private final ProdutoRepository produtoRepository;
    private final CompraRepository compraRepository;

    @KafkaListener(topics = "${topic.name}")
    public void consumer(ConsumerRecord<String, Compra> record, Acknowledgment ack) {
        var compra = record.value();
        log.info("Mensagem consumida " + compra.toString());
        var compraEntity = com.example.mercado.entity.Compra.builder().build();
        compraEntity.setIdCompra(compra.getIdCompra().toString());
        compraEntity.setDataCompra(LocalDateTime.now());
        compraEntity.setCpf(compra.getCpf().toString());
        compra.getProdutosCompradosList()
                .forEach(p -> produtoRepository
                        .findByNome(p.toString())
                        .ifPresent(produto -> compraEntity.getProdutosCompradosList()
                                .add(produto)));
        compraRepository.save(compraEntity);
        ack.acknowledge();
    }
}
