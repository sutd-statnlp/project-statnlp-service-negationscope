package org.statnlp.services.negationscope.util;

public class ConstantUtil {

    public static final String INPUT_FILE_PATH = "./input.txt";
    public static final String OUT_FILE_NAME = "output.txt.seq";
    public static final String OUT_FILE_PATH = "./" + OUT_FILE_NAME;
    public static final String DEFAULT_ARGS = "-modelname OIBAMN6 -thread 1 -skiptest false -skiptrain true -dataset cdsco -lang en -discrete true -discardintest false -syntax false -testrain false -outputsem2012 false -outputerror false -unipos true -modelfile OIBAMN6.model";
}
