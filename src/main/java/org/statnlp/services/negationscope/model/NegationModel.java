package org.statnlp.services.negationscope.model;

import java.util.List;

public interface NegationModel {
    List<Boolean> run(String [] words, String[] cues);
}
