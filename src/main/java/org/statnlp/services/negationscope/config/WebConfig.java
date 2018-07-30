package org.statnlp.services.negationscope.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class WebConfig implements ServletContextInitializer {

    private final Logger log = LoggerFactory.getLogger(WebConfig.class);

    private final Environment env;

    public WebConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public Executor asyncExecutor() {
        log.debug("Create Async Task Executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(env.getProperty("async.executor.core-pool-size",Integer.class));
        executor.setQueueCapacity(env.getProperty("async.executor.queue-capacity",Integer.class));
        executor.setThreadNamePrefix(env.getProperty("async.executor.thread-prefix"));
        executor.initialize();
        return executor;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("Web application fully configured");
    }
}
