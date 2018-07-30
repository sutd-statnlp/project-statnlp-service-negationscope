package org.statnlp.services.negationscope.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.statnlp.services.negationscope.service.DetectionService;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class DetectionRest {

    private final DetectionService detectionService;

    public DetectionRest(DetectionService detectionService) {
        this.detectionService = detectionService;
    }

    @PostMapping("/detect")
    public boolean[] detect(@RequestBody DetectionRequest detectionRequest) throws ExecutionException, InterruptedException {
        return this.detectionService.detect(detectionRequest).get();
    }
}
