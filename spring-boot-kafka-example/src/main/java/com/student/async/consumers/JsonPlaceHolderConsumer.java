package com.student.async.consumers;

import com.student.core.enums.TopicEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Slf4j
public class JsonPlaceHolderConsumer {

    @KafkaListener(topics = TopicEnum.TopicNames.JSON_PLACE_HOLDER_POSTS_TOPIC)
    public void consume(String message) throws InterruptedException {
        log.info("status=success, message={}", message);
        Thread.sleep(Duration.ofSeconds(1).toMillis()); //Simular consumidor lento
    }
}
