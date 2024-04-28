package com.example.laster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ThreadPoolConfig {
    @Bean("executorService")
    public ExecutorService getExecutorService(){
        return new ThreadPoolExecutor(20,20,3600, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2000));
    }

}
