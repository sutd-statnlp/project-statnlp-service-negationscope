package org.statnlp.services.negationscope.service;

import org.springframework.stereotype.Service;
import org.statnlp.services.negationscope.rest.DetectionRequest;

import java.util.concurrent.CompletableFuture;

@Service
public class DetectionServiceImpl implements DetectionService {
    @Override
    public CompletableFuture<boolean[]> detect(DetectionRequest detectionRequest) {
        String sentence = detectionRequest.getSentence();
        int scopeLength  = sentence.split(" ").length;
        return CompletableFuture.completedFuture(new boolean[scopeLength]);
    }
}
