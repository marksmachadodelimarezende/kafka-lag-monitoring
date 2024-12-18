package com.student.core.client;

import com.student.core.exception.KafkaException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaClientService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String key, String message) {
        try {
            kafkaTemplate.send(topic, key, message).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new KafkaException(e.getMessage());
        }
    }
}
