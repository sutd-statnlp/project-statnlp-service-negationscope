package org.statnlp.services.negationscope.util;

import org.apache.logging.log4j.util.Strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static boolean  writeWordCueToFile(String[] words, String[] cues){
        Path path = Paths.get(ConstantUtil.INPUT_FILE_PATH);
        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            for (int i = 0; i < words.length; i++) {
                writer.write(words[i]);
                writer.write("\t");

                String cue = cues[i];
                if (cue == null) {
                    cue = "_";
                }
                writer.write(cue);

                writer.newLine();
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    public static List<Boolean>  readOutputFile() {
        Path path = Paths.get(ConstantUtil.OUT_FILE_PATH);
        try (BufferedReader reader = Files.newBufferedReader(path))
        {
            List<Boolean> scopes = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (Strings.isEmpty(line)) {
                    continue;
                }
                boolean scope = line.split("\t")[2].equals("1");
                scopes.add(scope);
            }
            reader.close();
            return scopes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
