
package com.ada.mercado.producer;

import com.ada.mercado.Compra;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompraProducer {
    private final String topicName;
    private final KafkaTemplate<String, Compra> kafkaTemplate;


    public CompraProducer(@Value("${topic.name}")String topicName, KafkaTemplate<String, Compra> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Compra compra){
        kafkaTemplate.send(topicName, compra).addCallback(
                sucess -> log.info("Mensagem enviada com sucesso!"),
                failure -> log.error("Falha ao Enviar Menssagem!")
        );
    }
}

