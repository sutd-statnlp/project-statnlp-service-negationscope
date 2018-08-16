package org.statnlp.services.negationscope.rest;

import java.io.Serializable;
import java.util.Arrays;

public class DetectionRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String[] words;
    private String[] cues;

    public DetectionRequest() {
    }

    public DetectionRequest(String[] words, String[] cues) {
        this.words = words;
        this.cues = cues;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public String[] getCues() {
        return cues;
    }

    public void setCues(String[] cues) {
        this.cues = cues;
    }

    @Override
    public String toString() {
        return "DetectionRequest{" +
            "words=" + Arrays.toString(words) +
            ", cues=" + Arrays.toString(cues) +
            '}';
    }
}
