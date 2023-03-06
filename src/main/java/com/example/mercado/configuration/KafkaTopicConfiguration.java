package com.example.mercado.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {
    public final String topicName;

    public KafkaTopicConfiguration(@Value("${topic.name}") String topic) {
        this.topicName = topic;
    }
    
    @Bean
    public NewTopic createTopic(){
        return new NewTopic(topicName, 1, (short) 1);
    }
}
