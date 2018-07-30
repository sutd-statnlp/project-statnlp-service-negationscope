package org.statnlp.services.negationscope.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.statnlp.services.negationscope.NegationScopeApplication;
import org.statnlp.services.negationscope.service.DetectionService;
import org.statnlp.services.negationscope.service.DetectionServiceTest;
import org.statnlp.services.negationscope.util.DataUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NegationScopeApplication.class)
public class DetectionRestTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private DetectionRequest detectionRequest;

    @Autowired
    private DetectionService detectionService;


    @Before
    public void setup() {
        detectionRequest = DetectionServiceTest.createDetectionRequest();
        MockitoAnnotations.initMocks(this);

        DetectionRest detectionRest = new DetectionRest(detectionService);
        this.mockMvc = MockMvcBuilders
            .standaloneSetup(detectionRest)
            .build();
    }

    @Test
    public void testDetect() throws Exception {
        mockMvc.perform(post("/api/detect")
            .contentType(DataUtil.APPLICATION_JSON_UTF8)
            .content(DataUtil.convertObjectToJsonBytes(detectionRequest)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
