
package com.ada.mercado.producer;

import com.ada.mercado.Compra;
import com.ada.mercado.Produto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProdutoProducer {
    private final String topicName;
    private final KafkaTemplate<String, Produto> kafkaTemplate;


    public ProdutoProducer(@Value("${topic.name}")String topicName, KafkaTemplate<String, Produto> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Produto produto){
        kafkaTemplate.send(topicName, produto).addCallback(
                sucess -> log.info("Mensagem enviada com sucesso!" + produto),
                failure -> log.error("Falha ao Enviar Menssagem!")
        );
    }
}

