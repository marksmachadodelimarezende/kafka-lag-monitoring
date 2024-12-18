package com.student.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static java.lang.String.format;

@Getter
public class JsonPlaceHolderApiException extends RuntimeException {

    private final HttpStatus statusCode;
    private final String body;
    private final String path;

    public JsonPlaceHolderApiException(final HttpStatus statusCode, final String body, final String path) {
        super(format("json-place-holder-api-error, statusCode=%s, path=%s", statusCode, path));
        this.statusCode = statusCode;
        this.body = body;
        this.path = path;
    }

}
