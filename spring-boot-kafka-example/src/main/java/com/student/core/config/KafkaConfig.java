package com.student.core.config;

import com.student.core.client.KafkaClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaConfig {

    @Bean
    public KafkaClientService kafkaClientService(KafkaTemplate<String, String> kafkaTemplate) {
        return new KafkaClientService(kafkaTemplate);
    }
}