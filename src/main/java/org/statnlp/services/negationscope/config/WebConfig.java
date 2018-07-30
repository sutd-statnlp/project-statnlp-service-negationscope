package org.statnlp.services.negationscope.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class WebConfig {

    private final Environment env;

    public WebConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(env.getProperty("async.executor.core-pool-size",Integer.class));
        executor.setQueueCapacity(env.getProperty("async.executor.queue-capacity",Integer.class));
        executor.setThreadNamePrefix(env.getProperty("async.executor.thread-prefix"));
        executor.initialize();
        return executor;
    }
}
