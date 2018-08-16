package org.statnlp.services.negationscope.service;

import org.statnlp.services.negationscope.rest.DetectionRequest;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface DetectionService {
    CompletableFuture<List<Boolean>> detect(DetectionRequest detectionRequest);
}
