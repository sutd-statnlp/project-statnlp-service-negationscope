package org.statnlp.services.negationscope.util;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.statnlp.services.negationscope.rest.DetectionRest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
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
                String[] words = line.split("\t");
                if (words.length < 2) {
                    continue;
                }
                boolean scope = words[2].equals("1");
                scopes.add(scope);
            }
            reader.close();
            return scopes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean watchFileChange (String fileName) {
        final Path path = Paths.get("./");
        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            while (true) {
                final WatchKey wk = watchService.take();
                for (WatchEvent<?> event : wk.pollEvents()) {
                    final Path changed = (Path) event.context();
                    if (changed.endsWith(fileName)) {
                        return true;
                    }
                }
                wk.reset();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
