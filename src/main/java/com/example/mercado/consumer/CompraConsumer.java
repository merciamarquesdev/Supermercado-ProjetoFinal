package com.example.mercado.consumer;

import com.ada.mercado.Compra;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompraConsumer {
    @KafkaListener(topics = "${topic.name}")
    public void consumer(ConsumerRecord<String, Compra> record, Acknowledgment ack) {
        var compra = record.value();
        log.info(compra.toString());
        ack.acknowledge();
    }
}
