package com.example.plasticmodels.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Logger {

    public void info(String methodName, Object object) {
        log.info("\n\t\t::: method: {} :::\n\t\t::: data : {} :::", methodName, object);
    }

}
