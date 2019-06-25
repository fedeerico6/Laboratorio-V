package com.parcial.primerparcial.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@org.springframework.context.annotation.Configuration
@EnableAsync
public class Configuration {

    @Value("${executor.maxPoolSize: 6}")
    private  Integer MAX_POOL_SIZE;

    @Value("${executor.queueCapacity: 12}")
    private  Integer QUEUE_CAPACITY;

    @Bean("Executor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(MAX_POOL_SIZE);
        executor.initialize();
        return executor;
    }
}
