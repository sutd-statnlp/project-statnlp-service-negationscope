package org.statnlp.services.negationscope.service;

import org.junit.Before;
import org.junit.Test;
import org.statnlp.services.negationscope.rest.DetectionRequest;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class DetectionServiceTest {

    private DetectionService detectionService;
    private DetectionRequest detectionRequest;


    public static DetectionRequest createDetectionRequest () {
        return  new DetectionRequest(
            "This is not real sentence.",
            new String[]{null,null,"no",null,null}
        );
    }


    @Before
    public void before() {
        detectionService = new DetectionServiceImpl();
        detectionRequest = createDetectionRequest();
    }

    @Test
    public void testDetect() throws ExecutionException, InterruptedException {
        boolean[] actual = detectionService.detect(detectionRequest).get();
        assertEquals(5, actual.length);
    }
}
