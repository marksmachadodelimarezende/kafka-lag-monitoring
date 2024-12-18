package com.student.core.exception;

public class KafkaException extends RuntimeException {

    public KafkaException(String message) {
        super(message);
    }

}
