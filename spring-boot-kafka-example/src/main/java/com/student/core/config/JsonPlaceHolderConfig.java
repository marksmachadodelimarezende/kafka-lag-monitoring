package com.student.core.config;

import com.student.core.client.JsonPlaceHolderClient;
import org.springframework.context.annotation.Bean;

public class JsonPlaceHolderConfig {

    @Bean
    public JsonPlaceHolderClient jsonPlaceHolderClient(JsonPlaceHolderProperties properties) {
        return new JsonPlaceHolderClient(properties);
    }
}
