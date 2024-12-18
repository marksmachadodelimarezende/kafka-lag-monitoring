package com.student.core.utils;

import ch.qos.logback.core.model.processor.ProcessorException;
import dev.failsafe.Failsafe;
import dev.failsafe.FailsafeExecutor;
import dev.failsafe.RetryPolicy;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.net.ConnectException;
import java.time.Duration;

@UtilityClass
@Slf4j
public class FailSafeUtils {

    public static FailsafeExecutor<Object> defaultFailSafe() {
        return Failsafe
          .with(buildRetryPolicy())
//          .onSuccess((event) -> log.info("status=onSuccess, event={}", event))
//          .onFailure((event) -> log.info("status=onFailure, event={}", event))
//          .onComplete((event) -> log.info("status=onComplete, event={}", event))
          ;
    }

    private static RetryPolicy<Object> buildRetryPolicy() {
        return RetryPolicy.builder()
          .withDelay(Duration.ofSeconds(3), Duration.ofSeconds(5))
          .withMaxRetries(3)
          .handle(ConnectException.class, ProcessorException.class)
          .build();
    }
}
