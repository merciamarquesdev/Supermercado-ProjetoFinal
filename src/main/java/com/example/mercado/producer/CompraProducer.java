

package com.example.mercado.producer;


import com.example.mercado.configuration.CompraDTO;
import com.example.mercado.configuration.RealizaCompra;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompraProducer {
    private final String topicName;
    private final KafkaTemplate<Object, CompraDTO> kafkaTemplate;

    public CompraProducer(@Value("${topic.name}") String topicName, KafkaTemplate<Object, CompraDTO> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(CompraDTO compraDTO){
        log.info("Mensagem enviada pelo kafka {}", compraDTO);
        kafkaTemplate.send(topicName,compraDTO);
    }
}

