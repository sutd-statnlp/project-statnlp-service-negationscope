package org.statnlp.services.negationscope.model;

import org.ns.negation.common.NegationScopeDemoMain;
import org.statnlp.services.negationscope.util.ConstantUtil;
import org.statnlp.services.negationscope.util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NegationDemoModel implements NegationModel {

    public static void main(String[] args) {
        NegationDemoModel model = new NegationDemoModel();
        List<Boolean> result = model.run(
            new String[]{"This", "is", "not", "real", "sentence", "."},
            new String[]{null, null, "no", null, null, null}
        );
        System.out.println(result);
    }

    @Override
    public List<Boolean> run(String[] words, String[] cues) {
        if (FileUtil.writeWordCueToFile(words, cues)) {
            new Thread(
                () -> {
                    try {
                        NegationScopeDemoMain.main(ConstantUtil.DEFAULT_ARGS.split(" "));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            ).start();
        }
        if (FileUtil.watchFileChange(ConstantUtil.OUT_FILE_NAME)) {
            return FileUtil.readOutputFile();
        }
        return new ArrayList<>();
    }
}
