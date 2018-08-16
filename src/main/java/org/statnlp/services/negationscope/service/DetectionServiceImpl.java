package org.statnlp.services.negationscope.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.statnlp.services.negationscope.model.NegationModel;
import org.statnlp.services.negationscope.rest.DetectionRequest;
import org.statnlp.services.negationscope.util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DetectionServiceImpl implements DetectionService {

    private final Logger log = LoggerFactory.getLogger(DetectionServiceImpl.class);

    private final NegationModel negationModel;

    public DetectionServiceImpl(NegationModel negationModel) {
        this.negationModel = negationModel;
    }

    @Override
    public CompletableFuture<List<Boolean>> detect(DetectionRequest detectionRequest) {
        log.debug("Request to detect with DetectionRequest : {}", detectionRequest);
        List<Boolean> scopes = negationModel.run(detectionRequest.getWords(), detectionRequest.getCues());
        return CompletableFuture.completedFuture(scopes);
    }
}
