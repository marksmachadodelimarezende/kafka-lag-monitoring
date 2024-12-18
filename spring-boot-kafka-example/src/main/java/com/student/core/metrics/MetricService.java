package com.student.core.metrics;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MetricService {

    public void increment() {
        increment(1);
    }

    public void increment(double increaseValue) {
        
    }

}
