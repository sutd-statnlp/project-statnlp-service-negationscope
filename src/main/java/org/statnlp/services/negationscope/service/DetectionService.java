package org.statnlp.services.negationscope.service;

import org.statnlp.services.negationscope.rest.DetectionRequest;

import java.util.concurrent.CompletableFuture;

public interface DetectionService {
    CompletableFuture<boolean[]> detect(DetectionRequest detectionRequest);
}
