package org.statnlp.services.negationscope.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.statnlp.services.negationscope.rest.DetectionRequest;

import java.util.concurrent.CompletableFuture;

@Service
public class DetectionServiceImpl implements DetectionService {

    private final Logger log = LoggerFactory.getLogger(DetectionServiceImpl.class);

    @Override
    public CompletableFuture<boolean[]> detect(DetectionRequest detectionRequest) {
        log.debug("Request to detect with DetectionRequest : {}", detectionRequest);
        String sentence = detectionRequest.getSentence();
        int scopeLength  = sentence.split(" ").length;
        return CompletableFuture.completedFuture(new boolean[scopeLength]);
    }
}
