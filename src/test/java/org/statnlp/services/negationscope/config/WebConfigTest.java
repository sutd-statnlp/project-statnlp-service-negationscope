package org.statnlp.services.negationscope.config;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.statnlp.services.negationscope.NegationScopeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NegationScopeApplication.class)
public class WebConfigTest {

    @Autowired
    private WebConfig webConfig;

    @Autowired
    private Executor asyncExecutor;

    @Test
    public void testWebConfig() {
        assertNotNull(webConfig);
    }

    @Test
    public void testAsyncExecutor () {
        assertNotNull(webConfig.asyncExecutor());
        assertNotNull(asyncExecutor);

        ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) asyncExecutor;
        assertNotNull(executor);
        assertEquals(4, executor.getCorePoolSize());
        assertEquals("StatNLP-", executor.getThreadNamePrefix());
    }
}
