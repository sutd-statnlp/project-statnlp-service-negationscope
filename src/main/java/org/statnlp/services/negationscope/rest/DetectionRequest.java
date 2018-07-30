package org.statnlp.services.negationscope.rest;

import java.io.Serializable;

public class DetectionRequest implements Serializable {
    private String sentence;
    private String[] cues;

    public DetectionRequest() {
    }

    public DetectionRequest(String sentence, String[] cues) {
        this.sentence = sentence;
        this.cues = cues;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String[] getCues() {
        return cues;
    }

    public void setCues(String[] cues) {
        this.cues = cues;
    }
}
