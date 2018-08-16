package org.statnlp.services.negationscope.service;

import org.junit.Before;
import org.junit.Test;
import org.statnlp.services.negationscope.rest.DetectionRequest;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DetectionServiceTest {

    private DetectionService detectionService;
    private DetectionRequest detectionRequest;


    public static DetectionRequest createDetectionRequest () {
        return  new DetectionRequest(
            new String[]{"This", "is", "not", "real", "sentence", "."},
            new String[]{null,null,"no",null,null, null}
        );
    }


    @Before
    public void before() {
        detectionService = new DetectionServiceImpl();
        detectionRequest = createDetectionRequest();
    }

    @Test
    public void testDetect() throws ExecutionException, InterruptedException {
        List<Boolean> list = detectionService.detect(detectionRequest).get();
        assertNotNull(list);
    }
}
