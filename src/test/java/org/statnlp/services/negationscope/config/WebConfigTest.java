package org.statnlp.services.negationscope.config;

import org.statnlp.services.negationscope.NegationScopeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NegationScopeApplication.class)
public class WebConfigTest {

    @Autowired
    private WebConfig webConfig;

    @Test
    public void testGetSamplesInteractor() {
        assertNotNull(webConfig);
    }

}
