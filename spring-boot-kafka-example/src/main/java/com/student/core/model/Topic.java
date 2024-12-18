package com.student.core.model;

import lombok.Builder;

@Builder
public record Topic(String name) {

    private static final String SUFIX_DLQ = "-dlq";

    public String getDlqName() {
        return this.name().concat(SUFIX_DLQ);
    }
}
